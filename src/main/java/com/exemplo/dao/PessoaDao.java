package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Pessoa.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaDao {
    private Connection connection;

    public PessoaDao(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Pessoa pessoa) throws SQLException {
        String sql = "INSERT INTO Pessoa (nome, email, senha, dataDeNascimento, cpf, telefone, genero) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setDate(4, new java.sql.Date(pessoa.getDataDeNascimento().getTime()));
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getTelefone());
            stmt.setString(7, pessoa.getGenero().toString());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pessoa inserida com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
        finally {
            connection.close();
        }
    }

    public void delete(Long id) throws SQLException {
        String sql = "DELETE FROM Pessoa WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Pessoa excluída com sucesso!");
            } else {
                throw new SQLException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }

    public Pessoa selectById(Long id) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";

        Pessoa pessoa = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, String.valueOf(id));

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("dataDeNascimento"),
                            Pessoa.GENERO.valueOf(rs.getString("genero")),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else {
                    throw new SQLException("Pessoa não encontrada com o id fornecido.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            connection.close();
        }

        return pessoa;
    }

    public Pessoa selectByName(String nome) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE nome = ?";

        Pessoa pessoa = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, nome);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getString("nome"),
                            rs.getDate("dataDeNascimento"),
                            Pessoa.GENERO.valueOf(rs.getString("genero")),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else {
                    throw new SQLException("Pessoa não encontrada .");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            ConnectionFactory.closeConnection();
        }

        return pessoa;
    }

    public Pessoa selectCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE cpf = ?";

        Pessoa pessoa = null;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getString("nome"),
                            rs.getDate("dataDeNascimento"),
                            Pessoa.GENERO.valueOf(rs.getString("genero")),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else {
                    throw new SQLException("Pessoa não encontrada .");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            ConnectionFactory.closeConnection();
        }

        return pessoa;
    }

    public Pessoa selectLogin(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE email = ? and senha =?";

        Pessoa pessoa = null;

        try ( PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);


            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("dataDeNascimento"),
                            Pessoa.GENERO.valueOf(rs.getString("genero")),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha")
                    );
                } else {
                    throw new IllegalArgumentException("Pessoa não encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            ConnectionFactory.closeConnection();
        }

        return pessoa;
    }


}
