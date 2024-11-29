package com.exemplo.model.Animal;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Data
public class Animal {

    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String sexo;
    private String historicoMedico;
    private Date dataDeResgate;
    private String foto;
    private ADOCAO statusDeAdocao;

    public Animal(){}

    public enum ADOCAO{
        Adotado,
        EmProcesso,
        BuscandoNovoDono;
    }
}
