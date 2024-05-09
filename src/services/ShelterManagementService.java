package services;

import entities.AbstractAnimal;

import java.util.List;

public interface ShelterManagementService {
    List<AbstractAnimal> getListOfAnimals();
    AbstractAnimal getAnimalById(int animalId);
    boolean addAnimal(AbstractAnimal animal);
    int removeAnimal(AbstractAnimal animal);
}
