
# Usa a imagem do openjdk com Debian completo como base
FROM openjdk:17-slim

# Configura as versões do Maven e do Dockerize
ENV MAVEN_VERSION=3.8.5
ENV DOCKERIZE_VERSION=v0.6.1

WORKDIR /app

# Instala wget e tar
RUN apt-get update && \
    apt-get install -y wget tar

# Instala o Maven
RUN wget https://archive.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-$MAVEN_VERSION-bin.tar.gz && \
    tar -xzf apache-maven-$MAVEN_VERSION-bin.tar.gz -C /usr/local && \
    ln -s /usr/local/apache-maven-$MAVEN_VERSION/bin/mvn /usr/bin/mvn && \
    rm apache-maven-$MAVEN_VERSION-bin.tar.gz

# Instala o Dockerize
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \
    tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz && \
    rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY . .
EXPOSE 8080

RUN mvn install -T 8C

ENTRYPOINT ["dockerize", "-wait", "tcp://database:3306", "-timeout", "60s", "mvn", "spring-boot:run"]