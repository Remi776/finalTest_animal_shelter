package menu.impl;

import configs.ApplicationContext;
import entities.AbstractAnimal;
import entities.AnimalType;
import entities.impl.PackAnimal;
import entities.impl.Pet;
import entities.impl.ext.*;
import menu.Menu;
import services.ShelterManagementService;
import services.impl.DefaultShelterManagementService;
import util.Counter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ShelterCatalogMenu implements Menu {

    private static final String SHELTER_CATALOG_MENU = "1. Get a list of all animals" + System.lineSeparator()
            + "2. Add a new animal" + System.lineSeparator()
            + "3. Delete an animal from the list" + System.lineSeparator()
            + "4. Get full Animal Info " + System.lineSeparator()
            + "5. filter" + System.lineSeparator()
            + "6. Total amount of new added animals";

    private ApplicationContext context;
    private ShelterManagementService shelterManagementService;
    private Counter counter;

    {
        context = new ApplicationContext();
        shelterManagementService = new DefaultShelterManagementService();
        counter = new Counter();
    }

    @Override
    public void start() {
        Menu menuToNavigate = null;
        mainLoop:
        while (true) {
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");
            String userInput = sc.next();
            if (userInput.equalsIgnoreCase(MainMenu.MENU_COMMAND)) {
                menuToNavigate = new MainMenu();
                break;
            }

            switch (userInput) {
                case "1" -> printAllAnimalsFromShelter();
                case "2" -> {
                    try {
                        System.out.print("Enter the type of animal (available: " + Arrays.asList(AnimalType.values()) + "): ");
                        String inputAnimalType = sc.next().toUpperCase();
                        System.out.print("Enter the name of the animal: ");
                        String inputAnimalName = sc.next();
                        System.out.print("Enter the birth date (format: yyyy-mm-dd): ");
                        String inputAnimalBirthDate = sc.next();

                        addNewAnimal(inputAnimalType, inputAnimalName, inputAnimalBirthDate);
                        counter.increment();
                        System.out.println("Animal added.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Wrong values. Check input data.");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                case "3" -> {
                    System.out.print("Enter the ID of animal you want to remove: ");
                    int inputId = sc.nextInt();
                    if (deleteAnimalFromShelter(inputId) == -1) {
                        System.out.println("No such ID.");
                    } else {
                        System.out.println("Animal was removed.");
                    }
                }
                case "4" -> {
                    System.out.print("Enter the ID of animal: ");
                    int userId = sc.nextInt();
                    printFullAnimalInfo(userId);
                }
                case "5" -> new FilterMenu().start();

                case "6" -> System.out.println("Total amount of added animals: " + counter.getCount());
            }
        }
        menuToNavigate.start();
    }

    private void printFullAnimalInfo(int inputId) {
        StringBuilder fullInfo = new StringBuilder();
        AbstractAnimal animal = shelterManagementService.getAnimalById(inputId);
        if (animal instanceof Dog dog) {
            fullInfo.append(dog);
            fullInfo.append(", breed: ");
            fullInfo.append(dog.getBreed() != null ? dog.getBreed() : null);
            fullInfo.append(", commands: ");
            fullInfo.append(dog.getCommandList());
        } else if (animal instanceof Cat cat) {
            fullInfo.append(cat);
            fullInfo.append(", breed: ");
            fullInfo.append(cat.getBreed() != null ? cat.getBreed() : null);
            fullInfo.append(", commands: ");
            fullInfo.append(cat.getCommandList());
        } else if (animal instanceof Hamster hamster) {
            fullInfo.append(hamster);
            fullInfo.append(", commands: ");
            fullInfo.append(hamster.getCommandList());
        } else if (animal instanceof Horse horse) {
            fullInfo.append(horse);
            fullInfo.append(horse.getBreed() != null ? horse.getBreed() : null);
            fullInfo.append(horse.getSpeed() != 0 ? horse.getSpeed() : 0);
            fullInfo.append(", commands: ");
            fullInfo.append(horse.getCommandList());
        } else if (animal instanceof Donkey donkey) {
            fullInfo.append(donkey);
            fullInfo.append(donkey.getBreed() != null ? donkey.getBreed() : null);
            fullInfo.append(donkey.getSpeed() != 0 ? donkey.getSpeed() : 0);
            fullInfo.append(donkey.getLoadCapacity() != 0 ? donkey.getLoadCapacity() : 0);
            fullInfo.append(", commands: ");
            fullInfo.append(donkey.getCommandList());
        } else if (animal instanceof Camel camel) {
            fullInfo.append(camel);
            fullInfo.append(camel.getBreed() != null ? camel.getBreed() : null);
            fullInfo.append(camel.getSpeed() != 0 ? camel.getSpeed() : 0);
            fullInfo.append(camel.getLoadCapacity() != 0 ? camel.getLoadCapacity() : 0);
            fullInfo.append(", commands: ");
            fullInfo.append(camel.getCommandList());
        }
        System.out.println(fullInfo);
    }

    private void printAllAnimalsFromShelter() {
        for (AbstractAnimal animal : shelterManagementService.getListOfAnimals()) {
            if (animal instanceof Pet shelterPetAnimal) {
                System.out.println(shelterPetAnimal + "\t\t\t|Pet");
            } else if (animal instanceof PackAnimal shelterPackAnimal) {
                System.out.println(shelterPackAnimal + "\t\t\t|PackAnimal");
            }
        }
    }

    private boolean addNewAnimal(String inputAnimalType, String inputAnimalName, String inputAnimalBirthDate) {

        AbstractAnimal newAnimal = context.createAnimal(AnimalType.valueOf(inputAnimalType),
                inputAnimalName, LocalDate.parse(inputAnimalBirthDate));

        return shelterManagementService.addAnimal(newAnimal);
    }

    private int deleteAnimalFromShelter(int inputId) {
        AbstractAnimal animal = shelterManagementService.getAnimalById(inputId);
        return shelterManagementService.removeAnimal(animal);
    }


    @Override
    public void printMenuHeader() {
        System.out.println("***** SHELTER'S CATALOG MENU *****");
        System.out.println(SHELTER_CATALOG_MENU);
    }

}
