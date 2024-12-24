package com.flordacidade.api.flor_da_cidade_api.model;

import com.flordacidade.api.flor_da_cidade_api.model.Responsavel;
import com.flordacidade.api.flor_da_cidade_api.model.TipoEqu;
import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seqEqui;

    private String logradouro;
    private String numero;
    private String compl;
    private String validacao; // 'S' ou 'N'
    private Date datSol;
    private String nome;
    private String observ;
    private Integer qtdBancas;
    private Date datVal;
    private Time horario;
    private int qtdVisitas;

    @ManyToOne
    @JoinColumn(name = "seq_tipo_equ", nullable = false)
    private TipoEqu tipoEqu;

    @ManyToOne
    @JoinColumn(name = "seq_resp", nullable = false)
    private Responsavel responsavel;

    // Getters e Setters
    public int getSeqEqui() {
        return seqEqui;
    }

    public void setSeqEqui(int seqEqui) {
        this.seqEqui = seqEqui;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getValidacao() {
        return validacao;
    }

    public void setValidacao(String validacao) {
        this.validacao = validacao;
    }

    public Date getDatSol() {
        return datSol;
    }

    public void setDatSol(Date datSol) {
        this.datSol = datSol;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Date getDatVal() {
        return datVal;
    }

    public void setDatVal(Date datVal) {
        this.datVal = datVal;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public int getQtdVisitas() {
        return qtdVisitas;
    }

    public void setQtdVisitas(int qtdVisitas) {
        this.qtdVisitas = qtdVisitas;
    }

    public TipoEqu getTipoEqu() {
        return tipoEqu;
    }

    public void setTipoEqu(TipoEqu tipoEqu) {
        this.tipoEqu = tipoEqu;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
