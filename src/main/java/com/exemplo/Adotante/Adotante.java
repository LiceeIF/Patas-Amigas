package com.exemplo.Adotante;



import com.exemplo.Pessoa.Pessoa;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
public class Adotante extends Pessoa {

    private int idAdotante;
    private String preferenciasDeAdocao;
    private String adocoes;


}
