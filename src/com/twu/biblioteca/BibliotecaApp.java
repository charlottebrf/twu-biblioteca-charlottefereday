package com.twu.biblioteca;

import java.util.List;

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
        printer.display("\n**** Main Menu ****\n\n");
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
        while (userInput.equals("")) {
            printMainMenu();
            userInput = keyboard.read();
        }
        return menu.process(userInput);
    }

    public static void main(String[] args) {
        Library library = new Library();
        Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
        Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
        Book alphabet = new Book(new BookTitle("AAA"), new Author("BBBB"), new Year(2009));
        library.addBooks(harryPotter1);
        library.addBooks(hP2);
        BookRegister register = new BookRegister();
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
        register.addBooksToRegister(alphabet);

        Printer printer = new Printer();
        Keyboard keyboard = new Keyboard();
        BibliotecaApp bibliotecaApp = new BibliotecaApp(printer, library, new Menu(library, printer, register, keyboard), keyboard);

        bibliotecaApp.printWelcome();
        bibliotecaApp.interactiveMenu();
    }

}



