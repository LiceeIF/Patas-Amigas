package com.exemplo.model.Funcionario;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import com.exemplo.model.Pessoa.Pessoa;

@Getter
@Setter
@Builder
public class Funcionario {

    private Long id;
    private Long idPessoa;
    private Date dataContratacao;
    private String cargo;
    private float salario;
    private String departamento;


}
