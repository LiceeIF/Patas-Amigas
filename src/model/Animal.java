package model;
import java.util.Date;

public class Animal {

    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String sexo;
    private String historicoMedico;
    private Date dataDeResgate;
    private String foto;
    private String statysDeAdocao;

    public Animal(String nome, String especie, String raca, int idade, String sexo, String historicoMedico, Date dataDeResgate, String foto, String statysDeAdocao) {
        setNome(nome);
        this.especie = especie;
        this.raca = raca;
        setIdade(idade);
        this.sexo = sexo;
        this.historicoMedico = historicoMedico;
        this.dataDeResgate = dataDeResgate;
        this.foto = foto;
        setStatysDeAdocao(statysDeAdocao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {

        if (nome == null|| nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

   
    public void setIdade(int idade) {

        if (idade < 0){
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }

        this.idade = idade;     
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataDeResgate() {
        return dataDeResgate;
    }

    public void setDataDeResgate(Date dataDeResgate) {
        this.dataDeResgate = dataDeResgate;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getStatysDeAdocao() {
        return statysDeAdocao;
    }

    public void setStatysDeAdocao(String statysDeAdocao) {

        if (statysDeAdocao == null) {
            throw new IllegalArgumentException("O status de adoção é obrigatório.");
        }
        
        this.statysDeAdocao = statysDeAdocao;
    }
}
