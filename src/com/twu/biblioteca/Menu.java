package com.twu.biblioteca;
import java.util.Scanner;

public class Menu {
    private final Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public String process(String selection) {
        String menuChoice = "";
        switch (selection) {
            case "1":  menuChoice = this.library.getBookDetails();
                break;
        }
        return menuChoice;
    }
}


