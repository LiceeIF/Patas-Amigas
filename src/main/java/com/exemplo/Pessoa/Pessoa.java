package com.exemplo.Pessoa;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Data
@SuperBuilder
public abstract   class Pessoa {
    private String nome;
    private Date dataDeNascimento;
    private String genero;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;


    public static boolean isValidEmail(String email) {
        final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (email == null) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf.replaceAll("[.-]", "");
    }

    private void setEmail(String email) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public boolean validarSenha(String senha) {
        return senha.length() >= 12 &&
               senha.matches(".*[A-Z].*") &&
               senha.matches(".*[a-z].*") &&
               senha.matches(".*[0-9].*") &&
               senha.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\|,.<>\\/?].*");
    }

    public boolean validarCPF(String cpf) {
        if (cpf == null || cpf.isEmpty()) {
            return false;
        }
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

    @Override
    public String toString() {
        return "Pessoa {" +
                "Nome='" + getNome() + '\'' +
                ", Data de Nascimento='" +getDataDeNascimento() + '\'' +
                ", Gênero='" + getGenero() + '\'' +
                ", CPF='" + getCpf() + '\'' +
                ", Endereço='" + getEndereco() + '\'' +
                ", Telefone='" + getTelefone() + '\'' +
                ", Email='" + getEmail() + '\'' +
                '}';
    }
}
