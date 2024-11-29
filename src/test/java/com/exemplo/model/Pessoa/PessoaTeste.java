package com.exemplo.model.Pessoa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoaTeste {

    @Test
    @DisplayName("Verificar se a validação de cpf ocorre corretamente")
    public void cpfTeste(){
        Pessoa p =new Pessoa();
        p.setCpf("946.485.480-43");
        p.setCpf("946485.480-43");
        p.setCpf("94648548043");

    }
}
