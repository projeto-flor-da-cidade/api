package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Organiza") // Garante que o nome seja sempre em letras minúsculas
public class Organiza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_orga") // Define o nome da coluna explicitamente no banco de dados
    private Integer seqOrga;

    @Column(name = "nome", nullable = false, length = 60) // Nome da coluna no banco de dados
    private String nome;

    @Column(name = "endereco", nullable = false, length = 100) // Nome da coluna no banco de dados
    private String endereco;

    // Getters e Setters
    public Integer getSeqOrga() {
        return seqOrga;
    }

    public void setSeqOrga(Integer seqOrga) {
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
