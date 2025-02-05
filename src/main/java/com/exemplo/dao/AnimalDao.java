package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    private final Connection connection;

    public AnimalDao(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public List<Animal> select() {
        String sql = "SELECT * FROM Animal LIMIT 10";
        List<Animal> animais = new ArrayList<>();

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getLong("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setSexo(rs.getString("sexo"));
                animal.setHistoricoMedico(rs.getString("historico_medico"));
                animal.setDataDeResgate(rs.getDate("data_de_resgate"));

                InputStream fotoStream = rs.getBinaryStream("foto");
                animal.setFoto(fotoStream);

                animal.setStatusDeAdocao(Animal.ADOCAO.valueOf(rs.getString("status_de_adocao")));

                animais.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }

        return animais;
    }

    @SneakyThrows
    public Animal selectById(Long id) {
        String sql = "SELECT * FROM Animal WHERE id = ?";
        Animal animal = null;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    animal = new Animal();
                    animal.setId(rs.getLong("id"));
                    animal.setNome(rs.getString("nome"));
                    animal.setEspecie(rs.getString("especie"));
                    animal.setRaca(rs.getString("raca"));
                    animal.setSexo(rs.getString("sexo"));
                    animal.setHistoricoMedico(rs.getString("historico_medico"));
                    animal.setDataDeResgate(rs.getDate("data_de_resgate"));

                    InputStream fotoStream = rs.getBinaryStream("foto");
                    animal.setFoto(fotoStream);

                    animal.setStatusDeAdocao(Animal.ADOCAO.valueOf(rs.getString("status_de_adocao")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return animal;
    }

    public void inserirAnimal(Animal animal, Long idTutor, InputStream foto) throws SQLException {
        String sqlAnimal = "INSERT INTO Animal (nome, especie, raca, data_de_nascimento, data_de_resgate, foto, sexo, historico_medico, status_de_adocao) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?);";
        String sqlRelacao = "INSERT INTO Relacao (id_animal, id_usuario, relacao) VALUES (?, ?, ?);";
        String sqlRegistro = "INSERT INTO Registro (tipo_acao, descricao, pessoa_id, data_acao) VALUES (?, ?, ?, ?);"; // SQL para inserir o Registro

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement stmtAnimal = connection.prepareStatement(sqlAnimal, Statement.RETURN_GENERATED_KEYS)) {
                stmtAnimal.setString(1, animal.getNome());
                stmtAnimal.setString(2, animal.getEspecie());
                stmtAnimal.setString(3, animal.getRaca());
                stmtAnimal.setDate(4, new java.sql.Date(animal.getDataDeNascimento().getTime()));
                stmtAnimal.setDate(5, new java.sql.Date(animal.getDataDeResgate().getTime()));
                stmtAnimal.setBinaryStream(6, foto);
                stmtAnimal.setString(7, animal.getSexo());
                stmtAnimal.setString(8, animal.getHistoricoMedico());
                stmtAnimal.setString(9, String.valueOf(animal.getStatusDeAdocao()));

                int rowsInserted = stmtAnimal.executeUpdate();

                if (rowsInserted > 0) {
                    try (ResultSet generatedKeys = stmtAnimal.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            int idAnimal = generatedKeys.getInt(1);

                            if (idTutor != null) {
                                try (PreparedStatement stmtRelacao = connection.prepareStatement(sqlRelacao)) {
                                    stmtRelacao.setInt(1, idAnimal);
                                    stmtRelacao.setInt(2, Math.toIntExact(idTutor));
                                    stmtRelacao.setString(3, "Tutor");
                                    stmtRelacao.executeUpdate();
                                }
                            }

                            try (PreparedStatement stmtRegistro = connection.prepareStatement(sqlRegistro)) {
                                stmtRegistro.setString(1, "Cadastro de Animal");
                                stmtRegistro.setString(2, "Animal " + animal.getNome() + " colocado na adoção por Tutor/a.");
                                stmtRegistro.setLong(3, Math.toIntExact(idTutor));
                                stmtRegistro.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
                                stmtRegistro.executeUpdate();
                            }

                        }
                    }
                }

                connection.commit();
                System.out.println("Animal, relação e registro inseridos com sucesso!");
            } catch (SQLException e) {
                connection.rollback();
                throw new SQLException("Erro ao inserir o animal, a relação ou o registro: " + e.getMessage(), e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao inserir o animal", e);
        }
    }

}
