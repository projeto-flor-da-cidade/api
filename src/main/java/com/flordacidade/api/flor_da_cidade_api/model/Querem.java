package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "querem")
public class Querem {

    @EmbeddedId
    private QueremId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seqInt")
    @JoinColumn(name = "seq_int", nullable = false)
    private Interessados interessado;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("seqCurso")
    @JoinColumn(name = "seq_curso", nullable = false)
    private Curso curso;

    public Querem() {}

    public Querem(Interessados interessado, Curso curso) {
        this.interessado = interessado;
        this.curso = curso;
        this.id = new QueremId(interessado.getSeqInt(), curso.getId());
    }

    public QueremId getId() {
        return id;
    }

    public void setId(QueremId id) {
        this.id = id;
    }

    public Interessados getInteressado() {
        return interessado;
    }

    public void setInteressado(Interessados interessado) {
        this.interessado = interessado;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Querem querem = (Querem) o;
        return Objects.equals(id, querem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}