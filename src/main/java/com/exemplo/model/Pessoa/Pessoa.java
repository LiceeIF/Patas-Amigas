package com.exemplo.model.Pessoa;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.exemplo.model.Endereco.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Data
@SuperBuilder
public class Pessoa {
    @Setter private String nome;
    @Setter private Date dataDeNascimento;
    @Setter private GENERO genero;
    private String cpf;
    @Setter private Endereco endereco;
    @Setter private String telefone;
    @Setter private String email;
    @Setter private String senha;

    
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
        Homem,Mulher,NãoBinário,Intersexo;
    }
}

