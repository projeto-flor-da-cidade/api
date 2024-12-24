package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "local")
public class Local {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_loc")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @Column(name = "complemento", length = 30)
    private String complemento;

    @Column(name = "logradouro", nullable = false, length = 60)
    private String logradouro;

    @Column(name = "numero", nullable = false, length = 10)
    private String numero;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Local local = (Local) o;
        return Objects.equals(id, local.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
