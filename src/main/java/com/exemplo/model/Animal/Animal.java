package com.exemplo.model.Animal;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Date;

@Getter
@Setter
public class Animal {

    private Long id;
    private String nome;
    private String especie;
    private String raca;
    private Date dataDeNascimento;
    private String sexo;
    private String historicoMedico;
    private Date dataDeResgate;
    private InputStream foto;
    private ADOCAO statusDeAdocao;

    public Animal(){}

    public Animal(String nome, String especie, String raca, ADOCAO statusDeAdocao, InputStream foto, Date dataDeResgate, String historicoMedico, String sexo, Date dataDeNascimento) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.statusDeAdocao = statusDeAdocao;
        this.foto = foto;
        this.dataDeResgate = dataDeResgate;
        this.historicoMedico = historicoMedico;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
    }

    private byte[] fotoByteArray;

    public byte[] getFotoByteArray() throws IOException {
        if (fotoByteArray == null && foto != null) {
            fotoByteArray = foto.readAllBytes();
        }
        return fotoByteArray;
    }


    public String getFotoBase64() throws IOException {
        return Base64.getEncoder().encodeToString(getFotoByteArray());
    }

    public enum ADOCAO{
        Adotado,
        EmProcesso,
        BuscandoNovoDono;
    }
}
