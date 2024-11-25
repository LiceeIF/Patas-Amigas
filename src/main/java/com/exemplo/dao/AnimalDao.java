package com.exemplo.dao;

import com.exemplo.model.Animal.Animal;

import java.sql.Connection;

public class AnimalDao extends Base<Animal> {
    public AnimalDao(Animal animal) {
        super(animal);
    }
}
