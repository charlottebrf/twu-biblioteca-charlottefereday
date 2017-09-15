package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

public class LibraryTest {

    Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));

    Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), new Author("J.K.Rowlng"), new Year(1998));

    Library lib = new Library();

    @Before
    public void setUp() {
        Book harryPotter1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), new Author("J.K.Rowlng"), new Year(1997));
        BookTitle firstHP = new BookTitle("Harry Potter and the Philosopher's Stone");
        Author rowling = new Author("J.K.Rowlng");
        Library lib = new Library();
    }

    @Test
    public void addsABookToTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<Book> list = new LinkedList<Book>();
        list.add(harryPotter1);
        assertEquals(list, lib.getBooks());
    }

    @Test
    public void getsABookTitleFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = new BookTitle("Harry Potter and the Philosopher's Stone").getTitle();
        title.add(hpTitle);
        assertEquals(title, lib.getBookTitles());
    }

    @Test
    public void getsABookAuthorFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<String> author = new LinkedList<String>();
        String authorName = new Author("J.K.Rowlng").getAuthor();
        author.add(authorName);
        assertEquals(author, lib.getBookAuthors());
    }

    @Test
    public void getsABookYearFromTheLibrary() {
        lib.addBooks(harryPotter1);
        LinkedList<Integer> bookYear = new LinkedList<Integer>();
        Integer year1 = new Year(1997).getYear();
        bookYear.add(year1);
        assertEquals(bookYear, lib.getBookYears());
    }

    @Test
    public void getsAllBookInformationFromTheLibrary() {
        lib.addBooks(hP2);
        lib.addBooks(harryPotter1);

        assertEquals("|" + new BookTitle("Harry Potter and the Chamber of Secrets").getTitle() + "|" + new Author("J.K.Rowlng").getAuthor() + "|" + new Year(1998).getYear() + "|" + "\n" +
                               "|" + new BookTitle("Harry Potter and the Philosopher's Stone").getTitle() + "|" + new Author("J.K.Rowlng").getAuthor() + "|" + new Year(1997).getYear() + "|" + "\n",
                                lib.getBookDetails());
    }

    @Test
    public void updatesListOfBooksOnceABookHasBeenCheckedOut() throws Exception {
        lib.addBooks(harryPotter1);
        lib.addBooks(hP2);
        lib.removeBooks(hP2);

        LinkedList<String> title = new LinkedList<String>();
        String hpTitle = new BookTitle("Harry Potter and the Philosopher's Stone").getTitle();
        title.add(hpTitle);

        assertEquals(title, lib.getBookTitles());
    }
}