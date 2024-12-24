package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ocorrer")
public class Ocorrer {

    @Embeddable
    public static class OcorrerId implements Serializable {
        @Column(name = "seq_loc")
        private Integer seqLoc;

        @Column(name = "seq_tur")
        private Integer seqTur;

        public OcorrerId() {
        }

        public OcorrerId(Integer seqLoc, Integer seqTur) {
            this.seqLoc = seqLoc;
            this.seqTur = seqTur;
        }

        public Integer getSeqLoc() {
            return seqLoc;
        }

        public void setSeqLoc(Integer seqLoc) {
            this.seqLoc = seqLoc;
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
            OcorrerId that = (OcorrerId) o;
            return Objects.equals(seqLoc, that.seqLoc) && Objects.equals(seqTur, that.seqTur);
        }

        @Override
        public int hashCode() {
            return Objects.hash(seqLoc, seqTur);
        }
    }

    @EmbeddedId
    private OcorrerId id;

    @ManyToOne
    @MapsId("seqLoc")
    @JoinColumn(name = "seq_loc", referencedColumnName = "seq_loc", nullable = false)
    private Local local;

    @ManyToOne
    @MapsId("seqTur")
    @JoinColumn(name = "seq_tur", referencedColumnName = "seq_tur", nullable = false)
    private Turma turma;

    public Ocorrer() {
    }

    public Ocorrer(Local local, Turma turma) {
        this.local = local;
        this.turma = turma;
        this.id = new OcorrerId(local.getId(), turma.getId());
    }

    public OcorrerId getId() {
        return id;
    }

    public void setId(OcorrerId id) {
        this.id = id;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
