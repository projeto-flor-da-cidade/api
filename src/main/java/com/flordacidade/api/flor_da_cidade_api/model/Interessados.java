package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "interessados")
public class Interessados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqInt;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false)
    private Integer seqOrga;

    public Integer getSeqInt() {
        return seqInt;
    }

    public void setSeqInt(Integer seqInt) {
        this.seqInt = seqInt;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSeqOrga() {
        return seqOrga;
    }

    public void setSeqOrga(Integer seqOrga) {
        this.seqOrga = seqOrga;
    }
}
