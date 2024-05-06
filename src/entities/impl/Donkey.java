package entities.impl;

import entities.AnimalType;

import java.time.LocalDate;

public class Donkey extends Horse{

    private double loadCapacity;

    {
        setAnimalType(AnimalType.DONKEY);
    }

    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
    }

    public Donkey(String name, LocalDate birthDate, String breed, double speed) {
        super(name, birthDate, breed, speed);
        this.loadCapacity = DEFAULT_CAPACITY;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
