package com.example.model;
import java.util.Date;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private Date dataContratacao;
    private String cargo;
    private float salario;
    private String departamento;

    public Funcionario() {
        super(); 
    }

    public Funcionario(String nome, String dataDeNascimento, String genero, String cpf, String endereco, String telefone, 
                       String email, String senha, int idFuncionario, Date dataContratacao, String cargo, 
                       float salario, String departamento) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.idFuncionario = idFuncionario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;

    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario [Nome=" + getNome() + ", Data de Nascimento=" + getDataDeNascimento() + 
               ", Gênero=" + getGenero() + ", CPF=" + getCpf() + ", Endereço=" + getEndereco() + 
               ", Telefone=" + getTelefone() + ", Email=" + getEmail() + ", ID Funcionario=" + idFuncionario + 
               ", Data de Contratação=" + dataContratacao + ", Cargo=" + cargo + ", Salário=" + salario + 
               ", Departamento=" + departamento + "]";
    }
}
