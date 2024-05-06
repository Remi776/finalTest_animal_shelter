package entities.impl.ext;

import entities.impl.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    private String breed;
    private String speed;
    private double loadCapacity;

    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.loadCapacity = DEFAULT_CAPACITY;
    }

    public Camel(String name, LocalDate birthDate, String breed, String speed) {
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

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
