package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "organiza")
public class Organiza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seqOrga;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "endereco", nullable = false, length = 100)
    private String endereco;

    // Getters e Setters
    public int getSeqOrga() {
        return seqOrga;
    }

    public void setSeqOrga(int seqOrga) {
        this.seqOrga = seqOrga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
