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
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.sexo = sexo;
        this.historicoMedico = historicoMedico;
        this.dataDeResgate = dataDeResgate;
        this.foto = foto;
        this.statysDeAdocao = statysDeAdocao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
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
        this.statysDeAdocao = statysDeAdocao;
    }
}
