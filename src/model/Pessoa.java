package model;
import java.util.Date;

public class Pessoa  {
    private String nome;
    private Date dataDeNascimento;
    private String genero;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;

    public Pessoa(){}

    public Pessoa(String nome, Date dataDeNascimento, String genero, String cpf, String endereco, String telefone, String email, String senha) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }   

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }   


    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
     }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean validarSenha(){
        return senha.length() >= 12 &&
                senha.matches(".*[A-Z].*") &&
                senha.matches(".*[a-z].*") &&
                senha.matches(".*[0-9].*") &&
                senha.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>\\/?].*");
    }

    public Boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[.-]", "");
        if (cpf.length() != 11) {
            return false;
        }

        String semUltimosDois = cpf.substring(0, 9);
        int[] num = new int[]{10, 11};
        int[] resto = new int[2];

        for (int i = 0; i < 2; i++) {
            int valor = 0;
            for (int j = 0; j < semUltimosDois.length(); j++) {
                valor += num[i] * (cpf.charAt(j) - '0');
                num[i]--;
            }
            if (valor % 11 >= 2) {
                resto[i] = 11 - (valor % 11);
            } else {
                resto[i] = 0;
            }

            semUltimosDois += resto[i];
        }
        return resto[0] == (cpf.charAt(9) - '0') && resto[1] == (cpf.charAt(10) - '0');
    }
}