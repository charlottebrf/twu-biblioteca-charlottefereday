package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class BookRegisterTest {
    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream( stringy.getBytes() );
    }
    BookRegister register = new BookRegister();

    @Before
    public void setUp() throws Exception {
        register = new BookRegister();
        register.addBooksToRegister(harryPotter1);
        register.addBooksToRegister(hP2);
    }

    @Test
    public void booksCanBeAddedToRegister() {
        LinkedList<Book> expectedBooksInRegister = new LinkedList<Book>();
        expectedBooksInRegister.add(hP2);
        expectedBooksInRegister.add(harryPotter1);

        assertEquals(expectedBooksInRegister, register.getBooksInRegister());
    }

    @Test
    public void bookTitlesCanBeSearchedForInRegister() {

        assertEquals(harryPotter1,register.findBookInRegisterFromTitle("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void returnsNoBookWhenNotFoundInFromRegister() {
        Keyboard keyboard = new Keyboard(toStream("heqvdkjewvcjms"));
        BookRegister register3 = new BookRegister(keyboard);
        register3.addBooksToRegister(harryPotter1);
        register3.addBooksToRegister(hP2);

        assertEquals(Book.NO_BOOK, register3.findBookInRegisterFromTitle());
    }

    @Test
    public void booksCanBeRemovedFromRegister() throws Exception {
        LinkedList<Book> expectedBooksInRegister = new LinkedList<Book>();
        expectedBooksInRegister.add(hP2);
        register.removesBooksFromRegister(harryPotter1);

        assertEquals(expectedBooksInRegister, register.getBooksInRegister());
    }

    @Test
    public void returnsTrueIfBookIsPresent() {
        assertEquals(true,register.hasBookTitleInRegister("Harry Potter and the Philosopher's Stone"));
    }

    @Test
    public void returnsFalseIfBookIsNotPresent() {
        assertEquals(false,register.hasBookTitleInRegister("heqvdkjewvcjms"));
    }
}