package com.exemplo.model.Adotante;



import com.exemplo.model.Pessoa.Pessoa;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@Builder
public class Adotante{

    private Long id;
    private Long idAdotante;
    private String preferenciasDeAdocao;
    private String adocoes;


}
