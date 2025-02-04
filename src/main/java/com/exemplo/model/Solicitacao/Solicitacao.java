package com.exemplo.model.Solicitacao;

import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Solicitacao {

    private Long id;
    private Animal animal;
    private Pessoa dono;
    private Pessoa solicitador;
    private Boolean aceito;

    public Solicitacao(Animal animal, Pessoa dono, Pessoa solicitador, Boolean aceito) {
        this.animal = animal;
        this.dono = dono;
        this.solicitador = solicitador;
        this.aceito = aceito;
    }
}
