package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.dao.PessoaDao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class PessoaDaoTeste {

    @Test
    @DisplayName("Testa o insert da classe pessoa")
    public void insertTest() throws SQLException, IllegalAccessException {
        Pessoa p = Pessoa.builder()
                .nome("Quirinsssso Dog")
                .build();
        p.setCpf("380.029.390-00");

        PessoaDao pessoaDAo = new PessoaDao(p);
        pessoaDAo.post();

    }

    @Test
    @DisplayName("Testa o delete da classe pessoa")
    public void deleteTest() throws SQLException, IOException {
        try {
            Pessoa p = Pessoa.builder()
                    .nome("Quirino Dog")
                    .id(4L)
                    .build();


            PessoaDao pessoaDAo = new PessoaDao(p);
            pessoaDAo.delete();

        } catch (SQLException e) {
            throw  new SQLException(e.getMessage());

        }
    }
}
