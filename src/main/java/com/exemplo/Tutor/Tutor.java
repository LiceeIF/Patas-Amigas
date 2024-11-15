package com.exemplo.Tutor;

import com.exemplo.Pessoa.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class Tutor extends Pessoa {

    private int idTutor;
    private int numDeAnimais;  
    private String adocoes;

}
