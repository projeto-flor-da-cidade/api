package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "patrocina")
public class Patrocina {

    @Embeddable
    public static class PatrocinaId implements Serializable {
        @Column(name = "seq_orga")
        private Integer organizaId;

        @Column(name = "seq_equi")
        private Integer equipamentoId;

        public PatrocinaId() {
        }

        public PatrocinaId(Integer organizaId, Integer equipamentoId) {
            this.organizaId = organizaId;
            this.equipamentoId = equipamentoId;
        }

        public Integer getOrganizaId() {
            return organizaId;
        }

        public void setOrganizaId(Integer organizaId) {
            this.organizaId = organizaId;
        }

        public Integer getEquipamentoId() {
            return equipamentoId;
        }

        public void setEquipamentoId(Integer equipamentoId) {
            this.equipamentoId = equipamentoId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PatrocinaId that = (PatrocinaId) o;
            return Objects.equals(organizaId, that.organizaId) &&
                    Objects.equals(equipamentoId, that.equipamentoId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(organizaId, equipamentoId);
        }
    }

    @EmbeddedId
    private PatrocinaId id;

    public Patrocina() {
    }

    public Patrocina(PatrocinaId id) {
        this.id = id;
    }

    public PatrocinaId getId() {
        return id;
    }

    public void setId(PatrocinaId id) {
        this.id = id;
    }
}
