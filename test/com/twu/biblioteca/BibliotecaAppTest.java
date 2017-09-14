package com.twu.biblioteca;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    // TODO: Move these into a separate testing class/ library
    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    Printer printer = new Printer();

    BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
    Author rowling1 = new Author("J.K.Rowlng");
    Year year1 = new Year(1997);
    Book hP1 = new Book(firstHP, rowling1, year1);

    BookTitle secondHP = new BookTitle("Harry Potter and the Chamber of Secrets");
    Author rowling2 = new Author("J.K.Rowlng");
    Year year2 = new Year(1998);
    Book hP2 = new Book(secondHP, rowling2, year2);

    BookTitle thirdHP = new BookTitle("Harry Potter and the Prizioner of Azkaban");
    Author rowling3 = new Author("J.K.Rowlng");
    Year year3 = new Year(1999);
    Book hP3 = new Book(thirdHP, rowling3, year3);

    BookTitle fourthHP = new BookTitle("Harry Potter and the Goblet of Fire");
    Author rowling4 = new Author("J.K.Rowlng");
    Year year4 = new Year(2000);
    Book hP4 = new Book(fourthHP, rowling4, year4);

    BookTitle fifthHP = new BookTitle("Harry Potter and the Order of the Phoenix");
    Author rowling5 = new Author("J.K.Rowlng");
    Year year5 = new Year(2003);
    Book hP5 = new Book(fifthHP, rowling5, year5);

    BookTitle sixthHP = new BookTitle("Harry Potter and the Half Blood Prince");
    Author rowling6 = new Author("J.K.Rowlng");
    Year year6 = new Year(2005);
    Book hP6 = new Book(sixthHP, rowling6, year6);

    BookTitle seventhHP = new BookTitle("Harry Potter and the Deathly Hallows");
    Author rowling7 = new Author("J.K.Rowlng");
    Year year7 = new Year(2007);
    Book hP7 = new Book(seventhHP, rowling7, year7);

   Library lib = new Library();
   BibliotecaApp biblioteca = new BibliotecaApp(printer, lib);


    @Test
    public void displaysWelcomeMessage() {
        assertEquals(welcome, biblioteca.printWelcome());
    }

    public void helperMethodAddsBooksToLibrary() {
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
        this.helperMethodAddsBooksToLibrary();
        LinkedList<String> listOfTitles = new LinkedList<String>();
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

//        Todo: return these as a sorted collection, e.g. Collections.sort(listOfTitles);
        //test won't pass as in a different order
        assertEquals(listOfTitles, biblioteca.listLibraryBookTitles());
    }
}


