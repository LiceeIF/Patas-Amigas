package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Relacao.Relacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelacaoDao {

    private Connection connection;

    public RelacaoDao(Connection connection) {
        this.connection = connection;
    }

    public Relacao selectByAnimalId(Animal animal) throws SQLException {
        String sql = "SELECT r.id AS relacao_id, r.relacao, a.id AS animal_id, a.nome AS animal_nome, a.foto AS animal_foto, r.id_usuario " +
                "FROM Relacao r " +
                "INNER JOIN Animal a ON r.id_animal = a.id " +
                "WHERE r.id_animal = ?";
        Relacao relacao = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, String.valueOf(animal.getId()));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Animal animalResult = new Animal();
                    animalResult.setId(rs.getLong("animal_id"));
                    animalResult.setNome(rs.getString("animal_nome"));
                    animalResult.setFoto(rs.getBinaryStream("animal_foto"));

                    long idUsuario = rs.getLong("id_usuario");

                    PessoaDao pessoaDao = new PessoaDao(ConnectionFactory.getConnection());
                    Pessoa pessoa = pessoaDao.selectById(idUsuario);

                    relacao = new Relacao(
                            rs.getLong("relacao_id"),
                            animalResult,
                            pessoa, // A pessoa associada ao animal
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
            connection.close();
        }

        return relacao;
    }

    public List<Relacao> selectByUserId(Long id) throws SQLException {
        List<Relacao> relacoes = new ArrayList<>();
        String sql = "SELECT r.id AS relacao_id, r.relacao, r.id_usuario, a.id AS animal_id, a.nome AS animal_nome, a.foto AS animal_foto " +
                "FROM Relacao r " +
                "INNER JOIN Animal a ON r.id_animal = a.id " +
                "WHERE r.id_usuario = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Animal animal = new Animal();
                    animal.setId(rs.getLong("animal_id"));
                    animal.setNome(rs.getString("animal_nome"));
                    animal.setFoto(rs.getBinaryStream("animal_foto"));

                    Pessoa pessoa = new Pessoa(rs.getLong("id_usuario"));

                    Relacao relacao = new Relacao(
                            rs.getLong("relacao_id"),
                            animal,
                            pessoa,
                            rs.getString("relacao")
                    );
                    relacoes.add(relacao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
        }

        return relacoes;
    }


}
