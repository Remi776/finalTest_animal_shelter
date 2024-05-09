package entities.impl.ext;

import entities.AnimalType;
import entities.impl.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    private String breed;
    private double speed;
    private double loadCapacity;
    {
        setAnimalType(AnimalType.CAMEL);
    }

    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.loadCapacity = DEFAULT_CAPACITY;
    }

    public Camel(String name, LocalDate birthDate, String breed, double speed) {
        this(name, birthDate);
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

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
