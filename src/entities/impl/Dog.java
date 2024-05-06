package entities.impl;

import entities.AnimalType;
import entities.Pet;

import java.time.LocalDate;

public class Dog extends Pet {
    private String breed;

    {
        setAnimalType(AnimalType.DOG);
    }

    public Dog(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Dog(String name, LocalDate birthDate, String breed) {
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
