package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    String list = "1. List Books";
    String menu1 = "Main Menu";
    Printer printer = new Printer();


    private final Author author = new Author("J.K.Rowlng");
    private final Book hP1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), author, new Year(1997));
    private final Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), author, new Year(1998));

    Keyboard keyboard = new Keyboard(toStream("1"));
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream( stringy.getBytes() );
    }
    Library lib = new Library();
    Menu menu = new Menu(lib, hP1, printer, keyboard);
    BibliotecaApp biblioteca = new BibliotecaApp(printer, lib, menu, keyboard);

    @Before
    public void setUp() throws Exception {
        biblioteca = new BibliotecaApp(printer, lib, menu, keyboard);
        lib.addBooks(hP1);
        lib.addBooks(hP2);

    }

    @Test
    public void displaysListOfBooks() {
        List<String> listOfTitles = new LinkedList<>();
        String title2 = hP2.getBookTitle();
        listOfTitles.add(title2);
        String title1 = hP1.getBookTitle();
        listOfTitles.add(title1);


        assertEquals(listOfTitles, biblioteca.listLibraryBookTitles());
    }


    @Test
    public void delegatesInteractiveMenu() {

        assertEquals(   "|              Book Title               |   Author  | Year|\n" +
                        "|" + hP2.getBookTitle() + "|" + hP2.getBookAuthor() + "|" + hP2.getBookYear() + "|" + "\n" +
                        "|" + hP1.getBookTitle() + "|" + hP1.getBookAuthor() + "|" + hP1.getBookYear() + "|" + "\n",

                        biblioteca.interactiveMenu());
    }

}


