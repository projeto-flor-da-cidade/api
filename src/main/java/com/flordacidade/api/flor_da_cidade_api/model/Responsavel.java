package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "responsavel")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seqResp;

    @Column(nullable = false, length = 60)
    private String logradouro;

    @Column(nullable = false, length = 10)
    private String numero;

    @Column(nullable = false, length = 30)
    private String bairro;

    @Column(nullable = false, unique = true, length = 10)
    private String documento;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false)
    private String genero;

    @Column(length = 10)
    private String telefone;

    @Column(length = 30, unique = true)
    private String email;

    // Getters e Setters
    public Integer getSeqResp() {
        return seqResp;
    }

    public void setSeqResp(Integer seqResp) {
        this.seqResp = seqResp;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
}
