package com.exemplo.model.Tutor;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import com.exemplo.model.Pessoa.Pessoa;

@Getter
@Setter
@Builder
public class Tutor{

    private Long id;
    private Long idPessoa;
    private int numDeAnimais;  
    private String adocoes;

}
