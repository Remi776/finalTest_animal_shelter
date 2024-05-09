package menu.impl;

import configs.ApplicationContext;
import menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {
    public static final String MENU_COMMAND = "menu";
    private static final String MAIN_MENU = "Please, enter number in console to proceed." + System.lineSeparator()
            + "1. Shelter's Catalog" + System.lineSeparator()
            + "2. exit";

    @Override
    public void start() {

        Menu menuToNavigate = null;
        mainLoop:
        while (true) {
            printMenuHeader();
            Scanner sc = new Scanner(System.in);
            System.out.print("User input: ");
            int userInput = sc.nextInt();
            switch (userInput) {
                case 1:
                    menuToNavigate = new ShelterCatalogMenu();
                    break mainLoop;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Only 1, 2 is allowed. Try one more time.\n");
            }
        }
        menuToNavigate.start();
    }


    @Override
    public void printMenuHeader() {
        System.out.println("***** MAIN MENU *****");
        System.out.println(MAIN_MENU);
    }
}
