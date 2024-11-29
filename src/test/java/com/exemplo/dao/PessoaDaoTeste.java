package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Endereco.Endereco;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.dao.PessoaDao;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Date;

public class PessoaDaoTeste {

    @Test
    @DisplayName("Testa o insert da classe pessoa usando construtor")
    public void insertTest() throws SQLException{

        Endereco e = Endereco.builder()
                .bairro("Lepos")
                .localidade("SP")
                .logradouro("Rua lepo")
                .build();

        Pessoa p = new Pessoa(
                "Quirinssssssso Dog",
                new Date(),
                Pessoa.GENERO.Homem,
                "03529253103",
                "99999999999",
                "quirinssssssso@email.com",
                "123"
        );


        PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
        pessoaDao.inserir(p);
    }

    @Test
    @DisplayName("Testa o delete da classe pessoa usando construtor")
    public void deleteTeste() throws SQLException{

        PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
        pessoaDao.delete(5L);
    }

    @Test
    @DisplayName("Testa o select da classe pessoa usando construtor")
    public void selectTest() throws SQLException{

        PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
        System.out.println(pessoaDao.select("03529253103"));
    }

}
