package com.exemplo.Funcionario;
import com.exemplo.Pessoa.Pessoa;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@SuperBuilder
public class Funcionario extends Pessoa {
    private int idFuncionario;
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
