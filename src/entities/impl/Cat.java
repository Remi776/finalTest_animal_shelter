package entities.impl;

import entities.AnimalType;
import entities.Pet;

import java.time.LocalDate;

public class Cat extends Pet {
    private String breed;

    {
        setAnimalType(AnimalType.CAT);
    }

    public Cat(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Cat(String name, LocalDate birthDate, String breed) {
        super(name, birthDate);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
