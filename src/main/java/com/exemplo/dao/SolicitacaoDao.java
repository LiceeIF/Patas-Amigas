package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;
import com.exemplo.model.Solicitacao.Solicitacao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitacaoDao {

    private Connection connection;

    public SolicitacaoDao(Connection connection){
        this.connection = connection;
    }

    public void deleteByAnimalId(Long id) throws SQLException {
        String sql = "DELETE FROM Solicitacao WHERE id_animal = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Solicitação deletada com sucesso!");
            } else {
                System.out.println("Nenhuma solicitação encontrada com o ID fornecido.");
            }
        }
        catch (SQLException err){
            err.printStackTrace();
        }
    }

    public void insert(Solicitacao solicitacao) throws SQLException {
        String sqlQuery = "INSERT INTO Solicitacao (id_animal, id_dono, id_solicitador, aceito) VALUES (?, ?, ?, ?);";

        try (PreparedStatement stmt = connection.prepareStatement(sqlQuery)) {
            stmt.setLong(1, solicitacao.getAnimal().getId());
            stmt.setLong(2, solicitacao.getDono().getId());
            stmt.setLong(3, solicitacao.getSolicitador().getId());
            stmt.setBoolean(4, solicitacao.getAceito());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Solicitação inserida com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir solicitação", e);
        }
    }

    public List<Solicitacao> selectSolicitacoesByPessoaId(Long id) throws SQLException {
        String sql = "SELECT " +
                "s.aceito, " +
                "s.id_animal, "+
                "a.nome AS nome_animal, " +
                "a.especie, " +
                "a.raca, " +
                "a.foto AS foto_animal, " +
                "a.sexo, " +
                "a.status_de_adocao, " +
                "d.id AS dono_id, " +
                "d.nome AS nome_dono, " +
                "d.email AS email_dono, " +
                "d.telefone AS telefone_dono, "+
                "sol.id AS solicitador_id, " +
                "sol.nome AS nome_solicitador, " +
                "sol.telefone AS telefone_solicitador, "+
                "sol.email AS email_solicitador " +
                "FROM Solicitacao s " +
                "JOIN Animal a ON s.id_animal = a.id " +
                "JOIN Pessoa d ON s.id_dono = d.id " +
                "JOIN Pessoa sol ON s.id_solicitador = sol.id " +
                "WHERE s.id_dono = ?";

        List<Solicitacao> solicitacoes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Animal animal = new Animal(
                            rs.getLong("id_animal"),
                            rs.getString("nome_animal"),
                            rs.getString("especie"),
                            rs.getString("raca"),
                            rs.getString("sexo"),
                            rs.getBinaryStream("foto_animal")
                    );

                    Pessoa dono = new Pessoa(
                            rs.getLong("dono_id"),
                            rs.getString("nome_dono"),
                            rs.getString("telefone_dono"),
                            rs.getString("email_dono")
                    );

                    Pessoa solicitador = new Pessoa(
                            rs.getLong("solicitador_id"),
                            rs.getString("nome_solicitador"),
                            rs.getString("telefone_solicitador"),
                            rs.getString("email_solicitador")
                    );

                    Solicitacao solicitacao = new Solicitacao(animal, dono, solicitador, rs.getBoolean("aceito"));
                    solicitacoes.add(solicitacao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao selecionar solicitações", e);
        }

        return solicitacoes;
    }



}
