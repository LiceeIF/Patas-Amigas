package com.exemplo.model.Endereco;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Endereco {
    private String logradouro;
    private String bairro;
    private String localidade;
    private Integer numero;
}
