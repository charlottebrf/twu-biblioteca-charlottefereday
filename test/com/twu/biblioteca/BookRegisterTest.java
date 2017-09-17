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
        Keyboard keyboard = new Keyboard(toStream("Harry Potter and the Philosopher's Stone"));
        BookRegister register2 = new BookRegister(keyboard);
        register2.addBooksToRegister(harryPotter1);


        assertEquals(harryPotter1,register2.findBookInRegisterFromTitle());
    }
}