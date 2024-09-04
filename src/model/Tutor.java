package model;
import java.util.Date;

public class Tutor extends  Pessoa{

    private int idTutor;
    private int numDeAnimais;
    private String adocoes;

    public Tutor(int idTutor, int numDeAnimais, String adocoes) {
        this.idTutor = idTutor;
        this.numDeAnimais = numDeAnimais;
        this.adocoes = adocoes;
    }

    public Tutor(String nome, Date dataDeNascimento, String genero, String cpf, String endereco, String telefone, String email, String senha, int idTutor, int numDeAnimais, String adocoes) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.idTutor = idTutor;
        this.numDeAnimais = numDeAnimais;
        this.adocoes = adocoes;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getNumDeAnimais() {
        return numDeAnimais;
    }

    public void setNumDeAnimais(int numDeAnimais) {
        this.numDeAnimais = numDeAnimais;
    }

    public String getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(String adocoes) {
        this.adocoes = adocoes;
    }
}
