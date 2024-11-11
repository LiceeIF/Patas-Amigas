package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Funcionario extends Pessoa {
    private int idFuncionario;
    private LocalDate dataContratacao;
    private String cargo;
    private float salario;
    private String departamento;

    // Construtor padrão
    public Funcionario() {
        super(); // Chama o construtor da classe pai
    }

    public Funcionario(String nome, String dataDeNascimento, String genero, String cpf, String endereco, String telefone, 
                       String email, String senha, int idFuncionario, String dataContratacao, String cargo, 
                       float salario, String departamento) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.idFuncionario = idFuncionario;
        setDataContratacao(dataContratacao);
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

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    // Validação e conversão da data de contratação
    public void setDataContratacao(String data) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataContratacao = LocalDate.parse(data, formatter);

            if (dataContratacao.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Data de contratação não pode ser uma data futura.");
            }
            this.dataContratacao = dataContratacao;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de contratação inválida. Use o formato dd/MM/yyyy.");
        }
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
