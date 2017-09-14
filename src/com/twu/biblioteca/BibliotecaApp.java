package com.twu.biblioteca;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;

public class BibliotecaApp {
    private final Printer printer;
    private final Library library;

    public BibliotecaApp(Printer printer, Library library) {
        this.printer = printer;
        this.library = library;
    }

    public String printWelcome() {
        return printer.getWelcome();
    }

    public List<String> listLibraryBookTitles() {
        return library.getBookTitles();
    }

}
