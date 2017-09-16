package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Library library = new Library();
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
    Printer printer = new Printer();
    Keyboard keyboard = new Keyboard(toStream(harryPotter1.getBookTitle()));
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream( stringy.getBytes() );
    }
    Menu menu = new Menu(library, harryPotter1, printer, keyboard);


    String success = "Thank you! Enjoy the book";
    String success2 = "Thank you for returning the book.";

    @Before
    public void setUp() {
        menu = new Menu(library, harryPotter1, printer, keyboard);
        library.addBooks(hP2);
        library.addBooks(harryPotter1);
    }

    @Test
    public void canProcessAStringToSelectMenuOption() {
        assertEquals("|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                    "|" + harryPotter1.getBookTitle() + "|" + harryPotter1.getBookAuthor() + "|" + harryPotter1.getBookYear() + "|" + "\n",
                    menu.process());
    }

    @Test
    public void givesAMesageforAnInvalidOption() {
        "x";
        assertEquals("", menu.process());
    }

    @Test
    public void givesAQuitOption() {
        "2";
        assertEquals("", menu.process());
    }


    @Test
    public void checkoutABookOption() {
        assertEquals(success, menu.checkOutBook());
    }

    @Test
    public void returnABookOption() {
        assertEquals(success2, menu.returnBook());
    }
}