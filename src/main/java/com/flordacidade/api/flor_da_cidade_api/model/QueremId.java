package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QueremId implements Serializable {

    @Column(name = "seq_int")
    private Integer seqInt;

    @Column(name = "seq_curso") // Atualizado para refletir a coluna na tabela
    private Integer seqCurso;

    // Construtores
    public QueremId() {}

    public QueremId(Integer seqInt, Integer seqCurso) {
        this.seqInt = seqInt;
        this.seqCurso = seqCurso;
    }

    // Getters e Setters
    public Integer getSeqInt() {
        return seqInt;
    }

    public void setSeqInt(Integer seqInt) {
        this.seqInt = seqInt;
    }

    public Integer getSeqCurso() {
        return seqCurso;
    }

    public void setSeqCurso(Integer seqCurso) {
        this.seqCurso = seqCurso;
    }

    // hashCode e equals (importante para chaves compostas)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueremId queremId = (QueremId) o;
        return Objects.equals(seqInt, queremId.seqInt) && Objects.equals(seqCurso, queremId.seqCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqInt, seqCurso);
    }
}
