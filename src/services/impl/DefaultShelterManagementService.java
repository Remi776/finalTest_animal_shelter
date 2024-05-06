package services.impl;

import entities.AbstractAnimal;
import entities.AnimalType;
import entities.Command;
import entities.impl.PackAnimal;
import entities.impl.Pet;
import entities.impl.ext.*;
import services.ShelterManagementService;

import java.time.LocalDate;
import java.util.*;

public class DefaultShelterManagementService implements ShelterManagementService {
    Map<Integer, AbstractAnimal> dbShelter;

    public DefaultShelterManagementService() {
        init();
    }

    private void init() {

        Pet cat1 = new Cat("Chopick", LocalDate.of(2022, 8, 1));
        cat1.learnCommand(new Command("paw"));

        Pet cat2 = new Cat("Stephan", LocalDate.of(2024, 1, 1));
        cat2.learnCommand(new Command("jump", "The cat jumps up."));

        Pet dog1 = new Dog("Clay", LocalDate.of(2015, 4, 13), "Labrador");
        dog1.learnCommand(new Command("sit"));
        dog1.learnCommand(new Command("fetch"));

        Pet dog2 = new Dog("Grusha", LocalDate.of(2011, 12, 25));
        dog2.learnCommand(new Command("bark"));

        Pet hamster = new Hamster("Smack", LocalDate.of(2023, 1, 10));
        hamster.learnCommand(new Command("roll"));

        Camel camel = new Camel("Bogdan", LocalDate.of(2022, 3, 27));
        camel.setLoadCapacity(200.0);
        camel.learnCommand(new Command("load"));

        Horse horse1 = new Horse("Layla", LocalDate.of(2020, 7, 19), "Arabian", 70.0);
        horse1.learnCommand(new Command("gallop"));

        Horse horse2 = new Horse("Frida", LocalDate.of(2019, 12, 25));
        horse2.learnCommand(new Command("canter"));

        Donkey donkey1 = new Donkey("Simon", LocalDate.of(2021, 5, 8));
        donkey1.learnCommand(new Command("walk"));

        Donkey donkey2 = new Donkey("Parsifal", LocalDate.of(2023, 3, 27));
        donkey2.setLoadCapacity(250.0);
        donkey2.learnCommand(new Command("load", "Loads the bags."));

        dbShelter = new HashMap<>(Map.of(
                cat1.getId(), cat1,
                cat2.getId(), cat2,
                dog1.getId(), dog1,
                dog2.getId(), dog2,
                hamster.getId(), hamster,
                camel.getId(), camel,
                horse1.getId(), horse1,
                horse2.getId(), horse2,
                donkey1.getId(), donkey1,
                donkey2.getId(), donkey2
                ));
    }

    @Override
    public List<AbstractAnimal> getAllAnimals() {
        return new ArrayList<>(dbShelter.values());
    }

    @Override
    public AbstractAnimal getAnimalById(int animalId) {
        return dbShelter.getOrDefault(animalId, null);
    }

    @Override
    public boolean addAnimal(AbstractAnimal animal) {
        if (dbShelter.containsKey(animal.getId())) return false;
        dbShelter.put(animal.getId(), animal);
        return true;
    }

    @Override
    public int removeAnimal(AbstractAnimal animal) {
        if (!dbShelter.containsKey(animal.getId())) return -1;
        return dbShelter.remove(animal.getId()).getId();
    }
}
