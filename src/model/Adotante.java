package model;
import java.util.Date;

public class Adotante extends Pessoa {

    private int idAdotante;
    private String preferenciasDeAdocao;
    private String adocoes;

    // Construtor padrão
    public Adotante() {
        super(); // Chama o construtor da classe pai
    }

    public Adotante(int idAdotante, String preferenciasDeAdocao, String adocoes) {
        this.idAdotante = idAdotante;
        this.preferenciasDeAdocao = preferenciasDeAdocao;
        this.adocoes = adocoes;
    }

    public Adotante(String nome, Date dataDeNascimento, String genero, String cpf, String endereco, String telefone, String email, String senha, int idAdotante, String preferenciasDeAdocao, String adocoes) {
        super(nome, dataDeNascimento, genero, cpf, endereco, telefone, email, senha);
        this.idAdotante = idAdotante;
        this.preferenciasDeAdocao = preferenciasDeAdocao;
        this.adocoes = adocoes;
    }

    public int getIdAdotante() {
        return idAdotante;
    }

    public void setIdAdotante(int idAdotante) {
        this.idAdotante = idAdotante;
    }

    public String getPreferenciasDeAdocao() {
        return preferenciasDeAdocao;
    }

    public void setPreferenciasDeAdocao(String preferenciasDeAdocao) {
        this.preferenciasDeAdocao = preferenciasDeAdocao;
    }

    public String getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(String adocoes) {
        this.adocoes = adocoes;
    }
}
