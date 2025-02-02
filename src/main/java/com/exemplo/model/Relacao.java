package com.exemplo.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Relacao {

    private Integer idAnimal;
    private Integer id_usuario;
    private String relacao;
}
