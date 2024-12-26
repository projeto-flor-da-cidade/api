package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompoemId implements Serializable {
    private Integer seqPar;
    private Integer seqTur;

    public CompoemId() {}

    public CompoemId(Integer seqPar, Integer seqTur) {
        this.seqPar = seqPar;
        this.seqTur = seqTur;
    }

    public Integer getSeqPar() {
        return seqPar;
    }

    public void setSeqPar(Integer seqPar) {
        this.seqPar = seqPar;
    }

    public Integer getSeqTur() {
        return seqTur;
    }

    public void setSeqTur(Integer seqTur) {
        this.seqTur = seqTur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompoemId compoemId = (CompoemId) o;
        return Objects.equals(seqPar, compoemId.seqPar) && Objects.equals(seqTur, compoemId.seqTur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqPar, seqTur);
    }
}