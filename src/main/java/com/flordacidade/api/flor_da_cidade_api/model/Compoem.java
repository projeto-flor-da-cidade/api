package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "compoem")
public class Compoem {

    @EmbeddedId
    private CompoemId id;

    @ManyToOne
    @MapsId("seqPar")
    @JoinColumn(name = "seq_par", nullable = false)
    private Participantes participante;

    @ManyToOne
    @MapsId("seqTur")
    @JoinColumn(name = "seq_tur", nullable = false)
    private Turma turma;

    public Compoem() {}

    public Compoem(Participantes participante, Turma turma) {
        this.id = new CompoemId(participante.getSeqPar(), turma.getSeqTur());
        this.participante = participante;
        this.turma = turma;
    }

    public CompoemId getId() {
        return id;
    }

    public void setId(CompoemId id) {
        this.id = id;
    }

    public Participantes getParticipante() {
        return participante;
    }

    public void setParticipante(Participantes participante) {
        this.participante = participante;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
