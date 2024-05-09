package menu.impl;

import entities.AbstractAnimal;
import entities.impl.PackAnimal;
import entities.impl.Pet;
import menu.Menu;
import services.ShelterManagementService;
import services.impl.DefaultShelterManagementService;

import java.util.Scanner;

public class FilterMenu implements Menu {
    private static final String FILTER_MENU = "1. Filter Shelter By Pets" + System.lineSeparator()
            + "2. Filter Shelter by Pack Animals";

    private ShelterManagementService shelterManagementService;

    {
        shelterManagementService = new DefaultShelterManagementService();
    }

    @Override
    public void start() {
        printMenuHeader();
        System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.next();

        switch (userInput){
            case "1" -> filterShelterByPets();
            case "2" -> filterShelterByPackAnimals();
        }
        new ShelterCatalogMenu().start();
    }

    private void filterShelterByPets() {
        for (AbstractAnimal animal : shelterManagementService.getListOfAnimals()) {
            if (animal instanceof Pet) {
                System.out.println(animal + "\t\t\t|Pet");
            }
        }
    }

    private void filterShelterByPackAnimals() {
        for (AbstractAnimal animal : shelterManagementService.getListOfAnimals()) {
            if (animal instanceof PackAnimal) {
                System.out.println(animal + "\t\t\t|PackAnimal");
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** filter *****");
        System.out.println(FILTER_MENU);
    }
}
