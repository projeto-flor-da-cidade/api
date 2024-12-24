package com.flordacidade.api.flor_da_cidade_api.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitas")
public class Visitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seqVis;

    @Column(name = "data_vis", nullable = false)
    private Date dataVis;

    @Column(name = "observ", length = 60)
    private String observ;

    @ManyToOne
    @JoinColumn(name = "seq_tec", nullable = false)
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "seq_equi", nullable = false)
    private Equipamento equipamento;

    // Getters e Setters
    public int getSeqVis() {
        return seqVis;
    }

    public void setSeqVis(int seqVis) {
        this.seqVis = seqVis;
    }

    public Date getDataVis() {
        return dataVis;
    }

    public void setDataVis(Date dataVis) {
        this.dataVis = dataVis;
    }

    public String getObserv() {
        return observ;
    }

    public void setObserv(String observ) {
        this.observ = observ;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
}
