package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_tur")
    private int seqTur;

    @Column(name = "qtd_vag", nullable = false)
    private Integer quantidadeVagas;

    @Column(name = "horario", nullable = false)
    private LocalTime horario;

    @Column(name = "data_ini", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fin", nullable = false)
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "seq_curso", nullable = false)
    private Curso curso;

    // Validação de quantidade de vagas
    @PrePersist
    @PreUpdate
    private void validateQuantidadeVagas() {
        if (quantidadeVagas == null || quantidadeVagas <= 0) {
            throw new IllegalArgumentException("A quantidade de vagas deve ser maior que zero.");
        }
    }

    // Getters and Setters


    public int getSeqTur() {
        return seqTur;
    }

    public void setSeqTur(int seqTur) {
        this.seqTur = seqTur;
    }

    public Integer getQuantidadeVagas() {
        return quantidadeVagas;
    }

    public void setQuantidadeVagas(Integer quantidadeVagas) {
        this.quantidadeVagas = quantidadeVagas;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Turma turma = (Turma) o;
        return Objects.equals(seqTur, turma.seqTur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqTur);
    }
}
