package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "participantes") // Isso garante que a tabela será criada com esse nome no banco
public class Participantes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_par")
    private Integer seqPar;

    @Column(length = 10)
    private String conceito;

    @Column(nullable = false, length = 60)
    private String nome;

    // Getters e Setters
    public Integer getSeqPar() {
        return seqPar;
    }

    public void setSeqPar(Integer seqPar) {
        this.seqPar = seqPar;
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
