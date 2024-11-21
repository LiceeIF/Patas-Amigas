package com.exemplo.dao;

import com.exemplo.model.Animal.Animal;

import java.sql.Connection;

public class AnimalDao extends Base<Animal> {
    public AnimalDao(Connection connection, Animal animal) {
        super(connection, animal);
    }
}
