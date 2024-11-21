package com.exemplo.dao;

import com.exemplo.model.Pessoa.Pessoa;

import java.sql.Connection;

public class PessoaDao extends Base<Pessoa> {
    public PessoaDao(Connection connection, Pessoa pessoa) {
        super(connection, pessoa);
    }
}
