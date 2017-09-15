package com.twu.biblioteca;
import javax.lang.model.type.NullType;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.NoSuchElementException;
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

    public String printMainMenu() {
        return printer.getMenuHeader() + printer.getmainMenu();
    }

    public String printWelcome() {
        return printer.getWelcome();
    }

    public List<String> listLibraryBookTitles() {
        List<String> bookTitles = library.getBookTitles();
        sort(bookTitles);
        return bookTitles;
    }

    public String listFullLibraryBooks() {
        return library.getBookDetails();
    }

    private String catchException(String line, Scanner userInput) {
        try {
            userInput.next();
        } catch (Exception NoSuchElementException) {
            userInput.next();
        }
        return line;
    }

    private String catchNextException(Scanner userInput) {
        try {
            userInput.next();
        } catch (Exception NoSuchElementException) {
            userInput.next();
        }
        return userInput.next();
    }

    public String interactiveMenu(Scanner userInput) {
        String line = "";
        while (!(line = this.catchException(line,userInput)).isEmpty()) {
            this.printMainMenu();
        }
        return menu.process(this.catchNextException(userInput));
    }


}



