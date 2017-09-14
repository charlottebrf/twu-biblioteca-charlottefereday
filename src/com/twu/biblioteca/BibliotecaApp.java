package com.twu.biblioteca;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.Collections.sort;
import static java.util.stream.Collectors.toList;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;
    private final Menu menu;
    Scanner userInput = new Scanner(System.in);

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

    public List<String> listLibraryBookAuthors() {
        return library.getBookAuthors();
    }

    public List<Integer> listLibraryBookYears() {
        return library.getBookYears();
    }

    public String listFullLibraryBooks() {
        return library.getBookDetails();
    }

    public String interactiveMenu(Scanner userInput) {
        this.printMainMenu();
        return menu.process(userInput.next());
    }

}



