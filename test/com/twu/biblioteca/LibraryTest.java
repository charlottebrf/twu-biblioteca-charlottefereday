package com.twu.biblioteca;

import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void displaysALibraryBook() {
        Library lib = new Library();

        HashMap<String, ArrayList> multiMap = new  HashMap<String, ArrayList>();
        ArrayList<String> authorAndPublicationYear = new ArrayList<String>();
        authorAndPublicationYear.add("J.K.Rowling");
        authorAndPublicationYear.add("1997");
        multiMap.put("Harry Potter and the Philosopher's Stone", authorAndPublicationYear);

        assertEquals(multiMap, lib.getBooks());
    }
}