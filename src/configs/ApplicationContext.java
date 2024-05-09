package configs;

import entities.AbstractAnimal;
import entities.AnimalType;
import entities.impl.ext.*;
import menu.Menu;
import services.ShelterManagementService;
import util.Counter;

import java.time.LocalDate;

public class ApplicationContext {
    private Menu mainMenu;

    public AbstractAnimal createAnimal(AnimalType animalType, String name, LocalDate birthDate){
        return switch (animalType) {
            case CAMEL -> new Camel(name, birthDate);
            case CAT -> new Cat(name, birthDate);
            case DOG -> new Dog(name, birthDate);
            case DONKEY -> new Donkey(name, birthDate);
            case HAMSTER -> new Hamster(name, birthDate);
            case HORSE -> new Horse(name, birthDate);
        };
    }

    public Menu getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }

}
