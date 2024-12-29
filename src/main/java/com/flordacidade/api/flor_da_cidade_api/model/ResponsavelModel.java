package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "responsavel")
public class ResponsavelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResp;

    @Column(length = 60)
    private String logradouro;

    @Column(length = 10)
    private String numero;

    @Column(length = 30)
    private String bairro;

    @Column(length = 30)
    private String nome;

    @Column(length = 10)
    private String telefone;

    @Column(length = 30)
    private String email;

    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    // Getters e Setters

    public Long getIdResp() {
        return idResp;
    }

    public void setIdResp(Long idResp) {
        this.idResp = idResp;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
