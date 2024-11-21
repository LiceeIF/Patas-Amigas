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
@SuperBuilder
public class Funcionario extends Pessoa {
    private Long idFuncionario;
    private Date dataContratacao;
    private String cargo;
    private float salario;
    private String departamento;



    @Override
    public String toString() {
        return "Funcionario [Nome=" + getNome() + ", Data de Nascimento=" + getDataDeNascimento() + 
               ", Gênero=" + getGenero() + ", CPF=" + getCpf() + ", Endereço=" + getEndereco() + 
               ", Telefone=" + getTelefone() + ", Email=" + getEmail() + ", ID Funcionario=" + getIdFuncionario() + 
               ", Data de Contratação=" + getDataContratacao() + ", Cargo=" + getCargo() + ", Salário=" + getSalario() + 
               ", Departamento=" + getDepartamento() + "]";
    }
}
