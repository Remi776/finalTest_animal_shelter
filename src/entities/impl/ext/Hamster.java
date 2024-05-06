package entities.impl.ext;

import entities.AnimalType;
import entities.impl.Pet;

import java.time.LocalDate;

public class Hamster extends Pet {
    {
        setAnimalType(AnimalType.HAMSTER);
    }
    public Hamster(String name, LocalDate birthDate) {
        super(name, birthDate);
    }
}
