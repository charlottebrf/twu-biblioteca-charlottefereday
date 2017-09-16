package com.twu.biblioteca;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;
    private final Menu menu;

    public BibliotecaApp(Printer printer, Library library, Menu menu) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
    }

    public void printMainMenu() {
        printer.getMenuHeader();
        printer.getMainMenu();
    }

    public void printWelcome() {
        printer.getWelcome();
    }

    public List<String> listLibraryBookTitles() {
        List<String> bookTitles = library.getBookTitles();
        sort(bookTitles);
        return bookTitles;
    }

    public String listFullLibraryBooks() {
        return library.getBookDetails();
    }

    private String readInput(Scanner userInput) {
        try {
            return userInput.next();
        } catch (Exception NoSuchElementException) {
            return "";
        }
    }

    //Todo: fix so it doesn't print blank
    //Todo: if a user clicks to quit or enters the wrong option they'll get a console log the return is an empty string which should then break the below loop
    public String interactiveMenu(Scanner userInput) {
        String line = "";
        while (!(line = readInput(userInput)).isEmpty()) {
            this.printMainMenu();
        }
        return menu.process(line);
    }

}



