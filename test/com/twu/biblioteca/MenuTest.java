package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {
    Library library = new Library();
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowling"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowling"), new Year(1998));
    Printer printer = new Printer();
    BookRegister register = new BookRegister();

    Menu menu = new Menu(library, harryPotter1, printer, register);


    @Before
    public void setUp() {
        menu = new Menu(library, harryPotter1, printer, register);
        library.addBooks(hP2);
        library.addBooks(harryPotter1);
        register.addBooksToRegister(hP2);
        register.addBooksToRegister(harryPotter1);
    }

    @Test
    public void canProcessAStringToSelectMenuOption() {

        assertEquals("|              Book Title               |   Author  | Year|\n|Harry Potter and the Chamber of Secrets|J.K.Rowling|1998|\n|Harry Potter and the Philosopher's Stone|J.K.Rowling|1997|\n",
                    menu.process("1"));
    }

    @Test
    public void givesAMesageforAnInvalidOption() {

        assertEquals("Select a valid option!", menu.process("x"));
    }

    @Test
    public void givesAQuitOption() {
        assertEquals("You have selected quit: exiting the program now", menu.process("4"));
    }

//
//    @Test
//    public void checkoutABookOption() {
//        assertEquals("Thank you! Enjoy the book", menu.process("2"));
//    }
//
//    @Test
//    public void returnABookOption() {
//        assertEquals("Thank you for returning the book.", menu.process("3"));
//    }
}