package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_curso")
    private Integer id;

    @Column(name = "nome_curso", nullable = false, length = 30)
    private String nomeCurso;

    @Column(name = "carga_hor", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "ementa_cur", length = 60)
    private String ementa;

    @Column(name = "observ", length = 60)
    private String observacao;

    // Validação de carga horária
    @PrePersist
    @PreUpdate
    private void validateCargaHoraria() {
        if (cargaHoraria == null || cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária deve ser maior que zero.");
        }
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
