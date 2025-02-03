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

    public void insert(Solicitacao solicitacao) throws SQLException {
        String sqlQuery = "INSERT INTO Solicitacao (id_animal, id_dono,id_solicitador, aceito) VALUES (?,?,?,?);";

        try (PreparedStatement stmt = connection.prepareStatement(sqlQuery)){
            stmt.setLong(1, solicitacao.getIdAnimal());
            stmt.setLong(2, solicitacao.getIdDono());
            stmt.setLong(3, solicitacao.getIdSolicitador());
            stmt.setBoolean(4, solicitacao.getAceito());


            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pessoa inserida com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        finally {
            ConnectionFactory.closeConnection();
        }
    }
    public List<Solicitacao> selectSolicitacoesByPessoaId(Pessoa pessoa) throws SQLException {
        String sql = "SELECT * FROM Solicitacao WHERE id_dono =?";
        List<Solicitacao> solicitacoes = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, pessoa.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Solicitacao solicitacao = new Solicitacao(
                            rs.getLong("id_animal"),
                            rs.getLong("id_dono"),
                            rs.getLong("id_solicitador"),
                            rs.getBoolean("aceito")

                    );

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
