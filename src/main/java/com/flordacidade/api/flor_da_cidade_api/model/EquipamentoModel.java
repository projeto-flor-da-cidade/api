package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.sql.Time;

@Entity
@Table(name = "equipamento")
public class EquipamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEqui;

    @Size(max = 60)
    private String nome;

    private Integer tipoEqui;

    @Size(max = 120)
    private String observ;

    private String logradouro;

    private Integer qtdBancas;

    private Integer idResp;

    private Time Horario;
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

    public Integer getIdResp() {
        return idResp;
    }

    public void setIdResp(Integer idResp) {
        this.idResp = idResp;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Time getHorario() {
        return Horario;
    }

    public void setHorario(Time horario) {
        this.Horario = horario;
    }
}