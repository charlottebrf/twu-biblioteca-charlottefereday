package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;

import static org.junit.Assert.*;

public class ReturnsBooksCommandTest {
    Library library = new Library();
    Book a = new Book(new BookTitle("aaa"), new Author("bbb"), new Year(1997));
    int num = 1234567;
    LibraryNumber libnum = new LibraryNumber(num);
    Password password = new Password("abcdefgh");
    UserLogin login = new UserLogin(libnum, password);

    UserName userName = new UserName("Charlotte Fereday");
    UserEmailAddress email = new UserEmailAddress("foo@foo.com");
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);
    UserAccount account = new UserAccount(login, userName, email, number);
    LibraryRegister register = new LibraryRegister();

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    @Test
    public void allowsALoggedInUserToReturnABook() {
        register.addBooksToRegister(a);
        Keyboard keyboard = new Keyboard(toStream("1234567\nabcdefgh\naaa"));
        FakePrinter fakePrinter = new FakePrinter();
        ReturnsBooksCommand command = new ReturnsBooksCommand(library, fakePrinter, keyboard, account, register);
        command.execute();
        assertEquals("Thank you for returning the book.", fakePrinter.output());
    }

    @Test
    public void willNotAllowALoggedInUserToReturnAnInvalidBook() {
        register.addBooksToRegister(a);
        Keyboard keyboard = new Keyboard(toStream("1234567\nabcdefgh\nsdvsd"));
        FakePrinter fakePrinter = new FakePrinter();
        ReturnsBooksCommand command = new ReturnsBooksCommand(library, fakePrinter, keyboard, account, register);
        command.execute();
        assertEquals("That is not a valid book to return.", fakePrinter.output());
    }
}