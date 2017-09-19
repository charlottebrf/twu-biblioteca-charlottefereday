package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    Printer printer = new Printer();
    private final Author author = new Author("J.K.Rowlng");
    private final Book hP1 = new Book(new BookTitle("Harry Potter and the Philosopher's Stone"), author, new Year(1997));
    private final Book hP2 = new Book(new BookTitle("Harry Potter and the Chamber of Secrets"), author, new Year(1998));

    Keyboard keyboard = new Keyboard(toStream("1"));

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    Library lib = new Library();
    LibraryRegister register = new LibraryRegister();

    int num = 1234567;
    LibraryNumber libnum = new LibraryNumber(num);
    Password password = new Password("abcdefgh");
    UserLogin login = new UserLogin(libnum, password);
    UserName userName = new UserName("Charlotte Fereday");
    UserEmailAddress email = new UserEmailAddress("foo@foo.com");
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);
    UserAccount account = new UserAccount(login, userName, email, number);
    Menu menu = new Menu(account, lib, printer, register, keyboard);
    BibliotecaApp biblioteca = new BibliotecaApp(printer, lib, menu, keyboard);

    @Before
    public void setUp() throws Exception {
        biblioteca = new BibliotecaApp(printer, lib, menu, keyboard);
        lib.addBooks(hP1);
        lib.addBooks(hP2);
        register.addBooksToRegister(hP1);
        register.addBooksToRegister(hP2);
    }

}


