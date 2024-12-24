package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seqTec;

    @Column(nullable = false, length = 30)
    private String nome;

    // Getters e Setters
    public int getSeqTec() {
        return seqTec;
    }

    public void setSeqTec(int seqTec) {
        this.seqTec = seqTec;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
