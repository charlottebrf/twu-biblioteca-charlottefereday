package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    ByteArrayInputStream choice = new ByteArrayInputStream("Harry Potter and the Philosopher's Stone".getBytes());
    Scanner userInput = new Scanner(choice);

    Library library = new Library();
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
    Printer printer = new Printer();
    Menu menu = new Menu(library, harryPotter1, printer);

    @Test
    public void canProcessAStringToSelectMenuOption() {
        library.addBooks(hP2);
        library.addBooks(harryPotter1);

        assertEquals("|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                    "|" + harryPotter1.getBookTitle() + "|" + harryPotter1.getBookAuthor() + "|" + harryPotter1.getBookYear() + "|" + "\n",
                    menu.process("1"));
    }

    @Test
    public void givesAMesageforAnInvalidOption() {
        assertEquals("", menu.process("x"));
    }

    @Test
    public void givesAQuitOption() {
        assertEquals("", menu.process("3"));
    }

    @Test
    public void checkoutABookOption() {
        library.addBooks(harryPotter1);
        library.addBooks(hP2);
        menu.process("2");
        menu.checkOut(userInput);

        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = new BookTitle("Harry Potter and the Philosopher's Stone").getTitle();
        title.add(hpTitle);

        assertEquals(hpTitle, library.getBookTitles());
    }
}