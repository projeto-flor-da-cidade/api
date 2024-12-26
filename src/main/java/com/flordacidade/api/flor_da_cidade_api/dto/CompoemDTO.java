package com.flordacidade.api.flor_da_cidade_api.dto;

import com.flordacidade.api.flor_da_cidade_api.model.Compoem;
import com.flordacidade.api.flor_da_cidade_api.model.Participantes;
import com.flordacidade.api.flor_da_cidade_api.model.Turma;

public class CompoemDTO {

    private Integer seqPar;
    private Integer seqTur;

    // Getters e Setters
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

    // Converte o DTO para uma entidade Compoem
    public Compoem toCompoem() {
        Participantes participante = new Participantes();
        participante.setSeqPar(seqPar);

        Turma turma = new Turma();
        turma.setSeqTur(seqTur);

        return new Compoem(participante, turma);
    }
}
