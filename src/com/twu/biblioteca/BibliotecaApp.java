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
        printer.display("****" + printer.display("Main Menu") + "****" + "\n\n");
        printer.display("1. List Books\n2. Checkout books\n3. Return books\n4. Exit");
    }

    public void printWelcome() {
        printer.display("Welcome to the new Biblioteca App: we are open for business!");
    }

    public List<String> listLibraryBookTitles() {
        List<String> bookTitles = library.getBookTitles();
        sort(bookTitles);
        return bookTitles;
    }

    public String interactiveMenu() {
        String userInput = "";
        while ( userInput.equals("")) {
            printMainMenu();
            userInput = keyboard.read();
        }
        return menu.process(userInput);
    }

}



