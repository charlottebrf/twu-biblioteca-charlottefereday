package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));

    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream( stringy.getBytes() );
    }

    Library lib = new Library();


    @Before
    public void setUp() {
        lib = new Library();
        lib.addBooks(harryPotter1);
        lib.addBooks(hP2);
    }

    @Test
    public void addsABookToTheLibrary() {
        LinkedList<Book> expectedBooksInLib = new LinkedList<Book>();
        expectedBooksInLib.add(hP2);
        expectedBooksInLib.add(harryPotter1);

        assertEquals(expectedBooksInLib, lib.getBooks());
    }

    @Test
    public void getsABookTitleFromTheLibrary() {
        LinkedList<String> title = new LinkedList<String>();
        title.add(harryPotter1.getBookTitle());
        title.add(hP2.getBookTitle());
        Collections.sort(title);

        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void getsAllBookInformationFromTheLibrary() {
        assertEquals("|Harry Potter and the Chamber of Secrets|J.K.Rowlng|1998|\n|Harry Potter and the Philosopher's Stone|J.K.Rowlng|1997|\n",
                                lib.getBookDetails());
    }

    @Test
    public void updatesListOfBooksOnceABookHasBeenCheckedOut() throws Exception {
        lib.removeBooks(hP2);

        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = new BookTitle("Harry Potter and the Philosopher's Stone").getTitle();
        title.add(hpTitle);

        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void returnsABookObjectWhenGivenABookTitle() {
        Keyboard keyboard = new Keyboard(toStream(harryPotter1.getBookTitle()));
        Library lib2 = new Library(keyboard);

        assertEquals(harryPotter1, lib2.findBookFromTitle());
    }

    @Test
    public void returnsNoBookObjectWhenGivenABookTitle() {
        Keyboard keyboard = new Keyboard(toStream(harryPotter1.getBookTitle()));
        Library lib2 = new Library(keyboard);
        lib2.removeBooks(harryPotter1);

        assertEquals(null, lib2.findBookFromTitle());
    }

    @Test
    public void returnsFalseIfBookIsNotInTheLibrary() {
        lib.removeBooks(hP2);
        String title = hP2.getBookTitle();

        assertEquals(false, lib.hasBookTitleInLibrary(title));
    }

    @Test
    public void returnsTrueIfBookIsInTheLibrary() {
        String title = hP2.getBookTitle();

        assertEquals(true, lib.hasBookTitleInLibrary(title));
    }

}