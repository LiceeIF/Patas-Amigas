package com.exemplo.model.util;

import com.exemplo.model.Endereco.Endereco;
import com.exemplo.util.BuscaCEP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuscaCEPTeste {

    @Test
    @DisplayName("Verifica se o VIACEP está funcionando corretamente")
    void testeBuscaCEP() throws Exception {
        Endereco e = Endereco.
                builder()
                .logradouro("Rua Pedro Vicente")
                .localidade("São Paulo")
                .bairro("Luz")
                .build();

        Endereco endereco = BuscaCEP.buscaEnderecoPelo("01109-010");


        assertEquals(e, endereco);
    }


}
