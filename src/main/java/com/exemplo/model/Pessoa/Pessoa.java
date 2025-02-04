package com.exemplo.model.Pessoa;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

import com.exemplo.model.Endereco.Endereco;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter

public class Pessoa {
    @Setter private Long id;
    @Setter private String nome;
    @Setter private Date dataDeNascimento;
    @Setter private GENERO genero;
    private String cpf;
    @Setter private String telefone;
    @Setter private String email;
    @Setter private String senha;
    @Setter private InputStream foto;
    @Setter private Boolean adm;
    @Setter private Boolean tutor;
    @Setter private Boolean adotante;
    @Setter private Boolean funcionario;

    private byte[] fotoByteArray;

    public Pessoa(long id) {
        this.id = id;
    }

    public byte[] getFotoByteArray() throws IOException {
        if (fotoByteArray == null && foto != null) {
            fotoByteArray = foto.readAllBytes();
        }
        return fotoByteArray;
    }
    public String getFotoBase64() throws IOException {
        return Base64.getEncoder().encodeToString(getFotoByteArray());
    }

    public Pessoa(){}

    public Pessoa(Long id, String nome, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Pessoa(Long id, String nome, Date dataDeNascimento, GENERO genero, String cpf, String telefone, String email, String senha, InputStream foto, Boolean adm, Boolean tutor, Boolean adotante, Boolean funcionario) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.foto = foto;
        this.adm = adm;
        this.tutor = tutor;
        this.adotante = adotante;
        this.funcionario = funcionario;
    }

    public Pessoa(String nome, Date dataDeNascimento, GENERO genero, String cpf, String telefone, String email, String senha) {
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.genero = genero;
        setCpf(cpf);
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }


    public void setCpf(String cpf) {
        if (!validarCPF(cpf)) {
            throw new IllegalArgumentException("CPF inválido.");
        }
        this.cpf = cpf.replaceAll("[.-]", "");
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



    public enum GENERO{
        Homem,Mulher,NaoBinario,Intersexo;
    }
}

