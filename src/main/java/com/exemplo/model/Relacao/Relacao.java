package com.exemplo.model.Relacao;

import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relacao {

    private Long id;
    private Animal animal;
    private Pessoa usuario;
    private String relacao;

    public Relacao(Long id, Animal animal, Pessoa usuario, String relacao) {
        this.id = id;
        this.animal = animal;
        this.usuario = usuario;
        this.relacao = relacao;
    }
}
