package com.exemplo.model;

public class Tutor extends Pessoa {

    private int idTutor;
    private int nAnimais;
    private String adocoes;

    // Construtor padrão
    public Tutor() {
        super(); // Chama o construtor da classe pai
    }

    public Tutor(int idTutor, int numDeAnimais, String adocoes) {
        this.idTutor = idTutor;
        this.nAnimais = numDeAnimais;
        this.adocoes = adocoes;
    }

    public Tutor(String nome, String nascdate, String genero, String cpf, String endereco, String telefone, 
                 String email, String senha, int idTutor, int nAnimais, String adocoes) {
        super(nome, nascdate, genero, cpf, endereco, telefone, email, senha);
        this.idTutor = idTutor;
        this.nAnimais = nAnimais;
        this.adocoes = adocoes;
    }


    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public int getnAnimais() {
        return nAnimais;
    }

    public void setNumDeAnimais(int nAnimais) {
        this.nAnimais = nAnimais;
    }

    public String getAdocoes() {
        return adocoes;
    }

    public void setAdocoes(String adocoes) {
        this.adocoes = adocoes;
    }

    @Override
    public String toString() {
        return "Tutor [Nome: " + getNome() + ", CPF: " + getCpf() + ", Número de Animais: " + nAnimais + 
               ", Adoções: " + adocoes + "]";
    }
}
