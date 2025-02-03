package com.exemplo.model.Solicitacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Solicitacao {

    private Long id;
    private Long idAnimal;
    private Long idDono;
    private Long idSolicitador;
    private Boolean aceito;

    public Solicitacao(Long idAnimal, Long idDono, Long idSolicitador, Boolean aceito) {
        this.idAnimal = idAnimal;
        this.idDono = idDono;
        this.idSolicitador = idSolicitador;
        this.aceito = aceito;
    }
}
