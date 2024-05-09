package entities.impl.ext;

import entities.AnimalType;
import entities.impl.PackAnimal;

import java.time.LocalDate;

public class Horse extends PackAnimal {
    private String breed;
    private double speed;

    {
        setAnimalType(AnimalType.HORSE);
    }
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Horse(String name, LocalDate birthDate, String breed, double speed) {
        super(name, birthDate);
        this.breed = breed;
        this.speed = speed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }


}
