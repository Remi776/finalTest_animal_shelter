package entities.impl.ext;

import entities.AnimalType;
import entities.impl.PackAnimal;

import java.time.LocalDate;

public class Donkey extends Horse{

    private double loadCapacity;

    {
        setAnimalType(AnimalType.DONKEY);
    }

    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        this.loadCapacity = PackAnimal.DEFAULT_CAPACITY;
    }


    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
