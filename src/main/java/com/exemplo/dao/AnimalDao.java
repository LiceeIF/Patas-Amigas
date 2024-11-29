package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    private Connection connection;

    public AnimalDao(Connection connection) {
        this.connection = connection;
    }

    @SneakyThrows
    public List<Animal> select() {
        String sql = "SELECT * FROM Animal LIMIT 10";
        List<Animal> animais = new ArrayList<>();

        try (PreparedStatement stmt = this.connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Animal animal = new Animal();
                animal.setId(rs.getLong("id"));
                animal.setNome(rs.getString("nome"));
                animal.setEspecie(rs.getString("especie"));
                animal.setRaca(rs.getString("raca"));
                animal.setIdade(rs.getInt("idade"));
                animal.setSexo(rs.getString("sexo"));
                animal.setHistoricoMedico(rs.getString("historicoMedico"));
                animal.setDataDeResgate(rs.getDate("dataDeResgate"));
                animal.setFoto(rs.getString("foto"));
                animal.setStatusDeAdocao(Animal.ADOCAO.valueOf(rs.getString("statusDeAdocao")));

                animais.add(animal);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return animais;
    }
}
