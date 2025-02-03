package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Relacao.Relacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelacaoDao {

    private Connection connection;

    public RelacaoDao(Connection connection) {
        this.connection = connection;
    }

    public Relacao selectByAnimalId(Animal animal) throws SQLException {
        String sql = "SELECT * FROM Relacao WHERE id_animal=?";
        Relacao relacao = null;

        try(PreparedStatement stmt = connection.prepareStatement(sql)){

            stmt.setString(1, String.valueOf(animal.getId()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    relacao = new Relacao(
                            rs.getLong("id"),
                            rs.getLong("id_animal"),
                            rs.getLong("id_usuario"),
                            rs.getString("relacao")
                    );
                } else {
                    throw new SQLException("Animal não encontrado com relação alguma.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            ConnectionFactory.closeConnection();
        }

        return relacao;
    }
}
