package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;

@Entity
public class Querem {

    @EmbeddedId
    private QueremId id;

    @ManyToOne
    @MapsId("seqInt")
    @JoinColumn(name = "seq_int", nullable = false)
    private Interessados interessado;

    @ManyToOne
    @MapsId("seqCurso")
    @JoinColumn(name = "seq_curso", nullable = false)
    private Curso curso;

    public Querem() {}

    public Querem(Interessados interessado, Curso curso) {
        this.id = new QueremId(interessado.getSeqInt(), curso.getSeqCurso()); // Corrigido: curso.getId()
        this.interessado = interessado;
        this.curso = curso;
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
}
