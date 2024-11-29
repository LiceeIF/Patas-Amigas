package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.dao.AnimalDao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;

public class AnimalDaoTeste {
/*
    @Test
    @DisplayName("Testa o insert da classe animal")
    public void insertAnimal() throws SQLException, IllegalAccessException, NoSuchAlgorithmException, InvalidKeySpecException {
            Animal animal = Animal.builder()
                    .nome("Quirino Dog")
                    .idade(5)
                    .especie("Homem Sapos")
                    .foto("")
                    .raca("Humano")
                    .historicoMedico("")
                    .sexo("M")
                    .build();


            AnimalDao animalDao = new AnimalDao(animal);
            animalDao.post();


    }

    @Test
    @DisplayName("Testa o delete da classe animal")
    public void deleteAnimal() throws SQLException {
        try {
            Animal animal = Animal.builder()
                    .nome("Quirino Dog")
                    .id(12L)
                    .idade(5)
                    .especie("Homem Sapos")
                    .foto("")
                    .raca("Humano")
                    .historicoMedico("")
                    .sexo("M")
                    .build();


            AnimalDao animalDao = new AnimalDao( animal);
            animalDao.delete();

        } catch (SQLException e) {
            throw  new SQLException("Error: " + e.getMessage());
        }
    }*/
}
