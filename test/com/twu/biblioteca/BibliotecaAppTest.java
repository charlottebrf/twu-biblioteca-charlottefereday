package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    ByteArrayInputStream choice = new ByteArrayInputStream("1".getBytes());
    Scanner userInput = new Scanner(choice);

    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    String list = "1. List Books";
    String menu1 = "Main Menu";
    String displayMenu = "****" + menu1 + "****" + "\n\n" + list;
    Printer printer = new Printer();


    private final Author author = new Author("J.K.Rowlng");
    private final Book hP1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), author, new Year(1997));
    private final Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), author, new Year(1998));
    private final Book hP3 = new Book(new BookTitle("Harry Potter and the Prizioner of Azkaban"), author, new Year(1999));
    private final Book hP4 = new Book(new BookTitle("Harry Potter and the Goblet of Fire"), author, new Year(2000));
    private final Book hP5 = new Book(new BookTitle("Harry Potter and the Order of the Phoenix"), author, new Year(2003));
    private final Book hP6 = new Book(new BookTitle("Harry Potter and the Half Blood Prince"), author, new Year(2005));
    private final Book hP7 = new Book(new BookTitle("Harry Potter and the Deathly Hallows"), author, new Year(2007));

    Library lib = new Library();
    Menu menu = new Menu(lib);
    BibliotecaApp biblioteca = new BibliotecaApp(printer, lib, menu);


    @Test
    public void displaysWelcomeMessage() {
        assertEquals(welcome, biblioteca.printWelcome());
    }

    public void checkBooksIntoLibrary() {
        lib.addBooks(hP1);
        lib.addBooks(hP2);
        lib.addBooks(hP3);
        lib.addBooks(hP4);
        lib.addBooks(hP5);
        lib.addBooks(hP6);
        lib.addBooks(hP7);
    }

    @Test
    public void displaysListOfBooks() {
        this.checkBooksIntoLibrary();
        List<String> listOfTitles = new LinkedList<>();
        String title1 = hP1.getBookTitle();
        listOfTitles.add(title1);
        String title2 = hP2.getBookTitle();
        listOfTitles.add(title2);
        String title3 = hP3.getBookTitle();
        listOfTitles.add(title3);
        String title4 = hP4.getBookTitle();
        listOfTitles.add(title4);
        String title5 = hP5.getBookTitle();
        listOfTitles.add(title5);
        String title6 = hP6.getBookTitle();
        listOfTitles.add(title6);
        String title7 = hP7.getBookTitle();
        listOfTitles.add(title7);
        Collections.sort(listOfTitles);

        assertEquals(listOfTitles, biblioteca.listLibraryBookTitles());
    }


    @Test
    public void displaysFullDetailsOfBooks() {
        this.checkBooksIntoLibrary();
//        Todo: return these as a sorted collection, e.g. Collections.sort(listOfTitles);
        assertEquals(  "|" + hP7.getBookTitle() + "|" + hP7.getBookAuthor() + "|" + hP7.getBookYear() + "|" + "\n" +
                                "|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                                "|" + hP3.getBookTitle() + "|" + hP3.getBookAuthor() + "|" + hP3.getBookYear() + "|" + "\n" +
                                "|" + hP6.getBookTitle() + "|" + hP6.getBookAuthor() + "|" + hP6.getBookYear() + "|" + "\n" +
                                "|" + hP1.getBookTitle() + "|" + hP1.getBookAuthor() + "|" + hP1.getBookYear() + "|" + "\n" +
                                "|" + hP4.getBookTitle() + "|" + hP4.getBookAuthor() + "|" + hP4.getBookYear() + "|" + "\n" +
                                "|" + hP5.getBookTitle() + "|" + hP5.getBookAuthor() + "|" + hP5.getBookYear() + "|" + "\n",
                    biblioteca.listFullLibraryBooks());
    }

    @Test
    public void displaysMainMenu() {
        assertEquals(displayMenu, biblioteca.printMainMenu());
    }

    @Test
    public void delegatesInteractiveMenu() {
        this.checkBooksIntoLibrary();

        assertEquals(   "|" + hP7.getBookTitle() + "|" + hP7.getBookAuthor() + "|" + hP7.getBookYear() + "|" + "\n" +
                        "|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                        "|" + hP3.getBookTitle() + "|" + hP3.getBookAuthor() + "|" + hP3.getBookYear() + "|" + "\n" +
                        "|" + hP6.getBookTitle() + "|" + hP6.getBookAuthor() + "|" + hP6.getBookYear() + "|" + "\n" +
                        "|" + hP1.getBookTitle() + "|" + hP1.getBookAuthor() + "|" + hP1.getBookYear() + "|" + "\n" +
                        "|" + hP4.getBookTitle() + "|" + hP4.getBookAuthor() + "|" + hP4.getBookYear() + "|" + "\n" +
                        "|" + hP5.getBookTitle() + "|" + hP5.getBookAuthor() + "|" + hP5.getBookYear() + "|" + "\n",
                        biblioteca.interactiveMenu(userInput));
    }

}


