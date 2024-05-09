import menu.Menu;
import menu.impl.MainMenu;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new MainMenu();
        mainMenu.start();
    }
}