package com.exemplo.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConnectionFactoryTeste {

    @Test
    @DisplayName("Teste de conexão com o banco de dados")
    void testConexaoBanco() throws SQLException, IOException {
        Connection connection = ConnectionFactory.getConnection();
        ConnectionFactory.closeConnection();

    }
}
