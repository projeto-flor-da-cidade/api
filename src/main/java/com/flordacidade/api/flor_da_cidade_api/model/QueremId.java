package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QueremId implements Serializable {
    private Integer seqInt;
    private Integer seqCurso;

    public QueremId() {}

    public QueremId(Integer seqInt, Integer seqCurso) {
        this.seqInt = seqInt;
        this.seqCurso = seqCurso;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QueremId queremId = (QueremId) o;
        return Objects.equals(seqInt, queremId.seqInt) &&
                Objects.equals(seqCurso, queremId.seqCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqInt, seqCurso);
    }
}