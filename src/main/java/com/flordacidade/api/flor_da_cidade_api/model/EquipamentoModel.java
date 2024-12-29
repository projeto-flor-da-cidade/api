package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Equipamento")
public class EquipamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEqui;

    @Size(max = 60)
    private String nome;

    private Integer tipoEqui;

    @Size(max = 120)
    private String observ;

    private Integer qtdBancas;

    @ManyToOne
    @JoinColumn(name = "Id_resp", nullable = false)
    private ResponsavelModel responsavel;

    // Getters e Setters

    public Integer getIdEqui() {
        return idEqui;
    }

    public void setIdEqui(Integer idEqui) {
        this.idEqui = idEqui;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTipoEqui() {
        return tipoEqui;
    }

    public void setTipoEqui(Integer tipoEqui) {
        this.tipoEqui = tipoEqui;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Integer getQtdBancas() {
        return qtdBancas;
    }

    public void setQtdBancas(Integer qtdBancas) {
        this.qtdBancas = qtdBancas;
    }

    public ResponsavelModel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsavelModel responsavel) {
        this.responsavel = responsavel;
    }

}