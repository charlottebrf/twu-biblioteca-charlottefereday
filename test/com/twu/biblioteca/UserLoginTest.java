package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserLoginTest {
    String unguessable = "abcdefgh";
    String wrong = "xxx";
    int number = 1234567;
    int number2 = 1231111;
    Password password = new Password(unguessable);
    Password password2 = new Password(wrong);
    LibraryNumber libnum = new LibraryNumber(number);
    LibraryNumber libnum2 = new LibraryNumber(number2);
    UserLogin login = new UserLogin(libnum, password);

    @Before
    public void setUp() throws Exception {
        login =  new UserLogin(libnum, password);
    }

    @Test
    public void returnsTrueIfALoginIsValid() {
        assertEquals(true, login.isValid(libnum, password));
    }

    @Test
    public void returnsFalseIfALoginLibraryNumberIsInvalid() {
        assertEquals(false, login.isValid(libnum2, password));
    }

    @Test
    public void returnsFalseIfALoginPasswordIsInvalid() {
        assertEquals(false, login.isValid(libnum, password2));
    }

    @Test
    public void validPassword() {
        UserLogin login = new UserLogin(new LibraryNumber(1), new Password("foo"));

        assertTrue(login.isValid(new LibraryNumber(1), new Password("foo")));
    }

}