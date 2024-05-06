package entities.impl;

import entities.AnimalType;
import entities.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    {
        setAnimalType(AnimalType.HAMSTER);
    }
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
