package entities.impl;

import entities.PackAnimal;

import java.time.LocalDate;

public class Camel extends PackAnimal {
    private String breed;
    private String speed;
    private double loadCapacity;

    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Camel(String name, LocalDate birthDate, String breed, String speed) {
        super(name, birthDate);
        this.breed = breed;
        this.speed = speed;
        this.loadCapacity = DEFAULT_CAPACITY;
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
