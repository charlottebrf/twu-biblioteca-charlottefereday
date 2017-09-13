package com.twu.biblioteca;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void displaysAHashMapOfALibraryBook() {
        Library lib = new Library();
        HashMap<String, ArrayList> multiMap = lib.setBooks();
        assertEquals(multiMap, lib.getBooks());
    }

    @Test
    public void displaysAHashMapOfALibraryBook() {
        Library lib = new Library();
        lib.setBooks();
        String bookTitle = "Harry Potter and the Philosopher's Stone"
        assertEquals(bookTitle, lib.getBookTitles());
    }
}