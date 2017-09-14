package com.twu.biblioteca;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;
    private final Menu menu;

    public BibliotecaApp(Printer printer, Library library, Menu menu) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
    }

    //Todo: menu should be it's own class which can get user input - have a case statement to give the user options
    public String printMainMenu() {
        return printer.getMenuHeader() + printer.getmainMenu();
    }

    public String printWelcome() {
        return printer.getWelcome();
    }

    public List<String> listLibraryBookTitles() {
        return library.getBookTitles();
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

}



