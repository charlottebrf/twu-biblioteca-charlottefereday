package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    Library library = new Library();
    Menu menu = new Menu(library);

    BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
    Author rowling = new Author("J.K.Rowlng");
    Year year = new Year(1997);
    Book harryPotter1 = new Book(firstHP, rowling, year);

    BookTitle secondHP = new BookTitle("Harry Potter and the Chamber of Secrets");
    Author rowling2 = new Author("J.K.Rowlng");
    Year year2 = new Year(1998);
    Book hP2 = new Book(secondHP, rowling2, year2);

    @Test
    public void canProcessAStringToSelectMenuOption() {
        library.addBooks(hP2);
        library.addBooks(harryPotter1);

        assertEquals("|" + secondHP.getTitle() + "|" + rowling2.getAuthor() + "|" + year2.getYear() + "|" + "\n" +
                    "|" + firstHP.getTitle() + "|" + rowling.getAuthor() + "|" + year.getYear() + "|" + "\n",
                    menu.process("1"));
    }

    @Test
    public void givesAMesageforAnInvalidOption() {
        assertEquals("Select a valid option!", menu.process("x"));
    }

    @Test
    public void givesAQuitOption() {
        assertEquals("", menu.process("3"));
    }

    @Test
    public void checkoutABookOption() throws Exception {
        assertEquals("You have chosen to check out a book, redirecting you now", menu.process("2"));
    }
}