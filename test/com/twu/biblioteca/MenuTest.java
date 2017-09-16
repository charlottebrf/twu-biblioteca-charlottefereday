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
//    Keyboard keyboard = new Keyboard(toStream("1"));
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream( stringy.getBytes() );
    }
    Menu menu = new Menu(library, harryPotter1, printer);


    String success = "Thank you! Enjoy the book";
    String success2 = "Thank you for returning the book.";

    @Before
    public void setUp() {
        menu = new Menu(library, harryPotter1, printer);
        library.addBooks(hP2);
        library.addBooks(harryPotter1);
    }

    @Test
    public void canProcessAStringToSelectMenuOption() {
        Menu menu2 = new Menu(library, harryPotter1, printer);
        assertEquals("|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                    "|" + harryPotter1.getBookTitle() + "|" + harryPotter1.getBookAuthor() + "|" + harryPotter1.getBookYear() + "|" + "\n",
                    menu2.process("1"));
    }

    @Test
    public void givesAMesageforAnInvalidOption() {

        assertEquals("", menu.process("x"));
    }

    @Test
    public void givesAQuitOption() {
        assertEquals("", menu.process("4"));
    }


//    @Test
//    public void checkoutABookOption() {
//        assertEquals(success, menu.checkOutBook());
//    }
//
//    @Test
//    public void returnABookOption() {
//        assertEquals(success2, menu.returnBook());
//    }
}