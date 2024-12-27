# Projeto de Integração com Google Maps

Este projeto integra a API do Google Maps com um sistema de gerenciamento de marcadores no mapa. A aplicação permite visualizar a localização de pontos de interesse com base em dados fornecidos e inclui a criação de um marcador personalizado.

## Funcionalidades

- Exibição de mapa utilizando a API do Google Maps.
- Adição de marcadores customizados no mapa.
- Integração com a chave API para acesso aos serviços do Google Maps.
  
## Mudanças Recentes

### 1. Adição da Chave API
A chave API foi adicionada para permitir a comunicação com os serviços do Google Maps, possibilitando o carregamento do mapa e a interação com ele.

### 2. Criação do `index.html`
Foi criada a página inicial (`index.html`) para exibir o mapa e os elementos de interface relacionados aos marcadores.

### 3. Criação do `MarkerController`
Foi implementado um novo controlador, `MarkerController`, localizado na pasta `controller`. Este controlador gerencia as operações relacionadas aos marcadores no mapa, como a criação e remoção de marcadores.

### 4. Alteração no `GoogleMapsController.java`
O arquivo `GoogleMapsController.java` foi ajustado para compatibilidade com a nova chave API e para gerenciar melhor as interações com o Google Maps.

### 5. Alteração no `pom.xml`
Foi feito um pequeno ajuste no arquivo `pom.xml`, incluindo um espaço em branco para melhorar a legibilidade e a formatação do código.

## Como Rodar o Projeto

1. Clone o repositório.
2. Configure a chave API no arquivo de configuração.
3. Compile o projeto.
4. Acesse a página `index.html` no seu navegador para visualizar o mapa.

## Dependências

- Java 11 ou superior.
- Spring Boot (para o back-end).
- Maven (para gerenciamento de dependências).
- Google Maps API.

## Contribuição

1. Faça um fork deste repositório.
2. Crie uma branch com suas mudanças (`git checkout -b feature/nome-da-funcionalidade`).
3. Faça o commit das suas mudanças (`git commit -m 'feat: nova funcionalidade'`).
4. Envie para o repositório remoto (`git push origin feature/nome-da-funcionalidade`).
5. Abra um Pull Request.

