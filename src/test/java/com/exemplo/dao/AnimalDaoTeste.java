package com.exemplo.dao;

import com.exemplo.db.ConnectionFactory;
import com.exemplo.model.Animal.Animal;
import com.exemplo.dao.AnimalDao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AnimalDaoTeste {

    @Test
    @DisplayName("Testa o insert da classe animal")
    public void insertAnimal(){
        try {
            Animal animal = Animal.builder()
                    .nome("Quirino Dog")
                    .idade(5)
                    .especie("Homem Sapos")
                    .foto("")
                    .raca("Humano")
                    .historicoMedico("")
                    .sexo("M")
                    .build();

            Connection connection = ConnectionFactory.criaConnection();
            AnimalDao animalDao = new AnimalDao(connection, animal);
            animalDao.post();

        } catch (SQLException | IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
