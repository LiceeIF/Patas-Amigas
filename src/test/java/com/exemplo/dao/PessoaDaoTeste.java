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
    public void insertTest() throws SQLException, IOException {
        try {
        Pessoa p = Pessoa.builder()
                .nome("Quirino Dog")
                .build();

        Connection connection = ConnectionFactory.criaConnection();

        PessoaDao pessoaDAo = new PessoaDao(connection, p);
        pessoaDAo.post();

    } catch (SQLException | IOException e) {
        System.err.println("Error: " + e.getMessage());
    }
    }
}
