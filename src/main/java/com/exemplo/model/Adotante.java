package model;

public class Adotante extends Pessoa {

    private int idAdotante;
    private String preferenciasDeAdocao;
    private String adocoes;

    // Construtor padrão
    public Adotante() {
        super(); // Chama o construtor da classe pai
    }

    public Adotante(String nome, String nascDate, String genero, String cpf, String endereco, String telefone, 
                    String email, String senha, int idAdotante, String preferenciasDeAdocao, String adocoes) {
        super(nome, nascDate, genero, cpf, endereco, telefone, email, senha);
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

    @Override
    public String toString() {
        return "Adotante [Nome=" + getNome() + ", Data de Nascimento=" + getDataDeNascimento() + 
               ", Gênero=" + getGenero() + ", CPF=" + getCpf() + ", Endereço=" + getEndereco() + 
               ", Telefone=" + getTelefone() + ", Email=" + getEmail() + ", ID Adotante=" + idAdotante + 
               ", Preferências de Adoção=" + preferenciasDeAdocao + ", Adoções=" + adocoes + "]";
    }
}
