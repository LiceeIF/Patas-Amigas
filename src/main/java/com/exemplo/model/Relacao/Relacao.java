package com.exemplo.model.Relacao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relacao {

    private Long id;
    private Long idAnimal;
    private Long idUsuario;
    private String relacao;

    public Relacao(Long id, Long idAnimal, Long idUsuario, String relacao) {
        this.id = id;
        this.idAnimal = idAnimal;
        this.idUsuario = idUsuario;
        this.relacao = relacao;
    }
}
