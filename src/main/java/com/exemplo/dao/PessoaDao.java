package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.model.Pessoa.Pessoa;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PessoaDao {
    private Connection connection;

    public PessoaDao(Connection connection) {
        this.connection = connection;
    }

    public List<Pessoa> select() throws SQLException {
        List<Pessoa> pessoas = new ArrayList<>();

        String sql = "SELECT * FROM Pessoa LIMIT 100";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa(
                        rs.getLong("id"),
                        rs.getString("nome"),
                        rs.getBinaryStream("foto"),
                        rs.getString("genero"),
                        rs.getString("telefone"),
                        rs.getBoolean("funcionario"),
                        rs.getBoolean("tutor"),
                        rs.getBoolean("adotante")
                );
                pessoas.add(pessoa);
            }

            return pessoas;
        }
    }

    public void updatePessoa(Pessoa pessoa) throws SQLException, IOException  {
        String sql = "UPDATE Pessoa SET nome=?, genero=?, telefone=?, email=?, senha=?, foto=? WHERE id=?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setObject(2, pessoa.getGenero());
            stmt.setString(3, pessoa.getTelefone());
            stmt.setString(4, pessoa.getEmail());
            stmt.setString(5, pessoa.getSenha());
    
            InputStream fotoStream = pessoa.getFoto();
            if (fotoStream != null) {
                stmt.setBinaryStream(6, fotoStream, fotoStream.available()); 
            } else {
                stmt.setNull(6, java.sql.Types.BLOB); 
            }
    
            stmt.setLong(7, pessoa.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    

    public Pessoa updateTutor(Long id) throws SQLException {
        String sql = "UPDATE Pessoa SET tutor = TRUE WHERE id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Nenhuma pessoa encontrada com o ID fornecido.");
            }

            return selectById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void inserir(Pessoa pessoa) throws SQLException, IOException {
        String sql = "INSERT INTO Pessoa (nome, email, senha, data_de_nascimento, cpf, telefone, genero, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getEmail());
            stmt.setString(3, pessoa.getSenha());
            stmt.setDate(4, new java.sql.Date(pessoa.getDataDeNascimento().getTime()));
            stmt.setString(5, pessoa.getCpf());
            stmt.setString(6, pessoa.getTelefone());
            stmt.setString(7, pessoa.getGenero().toString());
    
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("imagens/default-image.jpg");
    
            if (inputStream == null) {
                throw new IOException("Imagem padrão não encontrada.");
            }
    
            stmt.setBinaryStream(8, inputStream, inputStream.available());
    
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Pessoa inserida com sucesso!");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            throw new SQLException(e);
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

    }

    public Pessoa selectById(Long id) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE id = ?";

        Pessoa pessoa = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("data_de_nascimento"),
                            rs.getString("genero"),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getBinaryStream("foto"),
                            rs.getBoolean("adm"),
                            rs.getBoolean("tutor"),
                            rs.getBoolean("adotante"),
                            rs.getBoolean("funcionario")

                    );
                } else {
                    throw new SQLException("Pessoa não encontrada com o id fornecido.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
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
                            rs.getDate("data_de_nascimento"),
                            rs.getString("genero"),
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
                            rs.getString("genero"),
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
        }

        return pessoa;
    }

    public Pessoa selectLogin(String email, String senha) throws SQLException {
        String sql = "SELECT * FROM Pessoa WHERE email = ? AND senha = ?";

        Pessoa pessoa = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    pessoa = new Pessoa(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("data_de_nascimento"),
                            rs.getString("genero"),
                            rs.getString("cpf"),
                            rs.getString("telefone"),
                            rs.getString("email"),
                            rs.getString("senha"),
                            rs.getBlob("foto") != null ? rs.getBlob("foto").getBinaryStream() : null, // Conversão de Blob para InputStream
                            rs.getBoolean("adm"),
                            rs.getBoolean("tutor"),
                            rs.getBoolean("adotante"),
                            rs.getBoolean("funcionario")
                    );
                } else {
                    throw new IllegalArgumentException("Pessoa não encontrada.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return pessoa;
    }

}
