package com.exemplo.dao;

import com.exemplo.model.Registro.Registro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistroDao{

    private Connection connection;

    public RegistroDao(Connection connection) {
        this.connection = connection;
    }

    public List<Registro> select() throws SQLException {
        String sql = "SELECT * FROM Registro;";
        List<Registro> registros = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Registro registro = new Registro();
                registro.setId(rs.getLong("id"));
                registro.setTipoAcao(rs.getString("tipo_acao"));
                registro.setDescricao(rs.getString("descricao"));
                registro.setPessoaId(rs.getLong("pessoa_id"));
                registro.setDataAcao(rs.getTimestamp("data_acao"));

                registros.add(registro);
            }
        } catch (SQLException err) {
            err.printStackTrace();
            throw err;
        }

        return registros;
    }

    public void insert(Registro registro) throws SQLException {
        String sql = "INSERT INTO Registro (tipo_acao, descricao, pessoa_id, data_acao) " +
                "VALUES (?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, registro.getTipoAcao());
            stmt.setString(2, registro.getDescricao());
            stmt.setLong(3, registro.getPessoaId());
            stmt.setTimestamp(4, new Timestamp(registro.getDataAcao().getTime()));


            stmt.executeUpdate();
        } catch (SQLException err) {
            err.printStackTrace();
            throw err;
        }
    }
}
