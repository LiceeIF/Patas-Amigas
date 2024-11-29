package com.exemplo.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    private static final String CONFIG_FILE = "src/main/resources/config.properties";
    private static final Properties dbProperties;
    private static Connection connection;
    static {
        try {
            dbProperties = new Properties();
            try (FileInputStream fis = new FileInputStream(CONFIG_FILE)) {
                dbProperties.load(fis);
            }
        } catch (IOException e) {
            throw new RuntimeException("Falha ao carregar configurações de banco de dados", e);
        }
    }

    private ConnectionFactory() {}

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            String url = dbProperties.getProperty("db.url");
            String user = dbProperties.getProperty("db.user");
            String password = dbProperties.getProperty("db.password");

            if (url == null || user == null) {
                throw new SQLException("Configurações de banco de dados inválidas.");
            }

            connection = DriverManager.getConnection(url, user, password);
        }

        return connection;
    }

    public static void  closeConnection() throws SQLException {
        try {
            connection.close();
        }
        catch (SQLException err){
            throw new SQLException(err);
        }
    }
}
