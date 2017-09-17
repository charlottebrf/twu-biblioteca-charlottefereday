package com.twu.biblioteca;
import java.util.List;
import java.util.Scanner;

import static java.util.Collections.sort;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;
    private final Menu menu;
    private final Keyboard keyboard;

    public BibliotecaApp(Printer printer, Library library, Menu menu, Keyboard keyboard) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
        this.keyboard = keyboard;
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

    public void interactiveMenu() {
        String userInput = "";
        while ( userInput.equals("")) {
            printMainMenu();
            userInput = keyboard.read();
        }
        menu.process(userInput);
    }

}



