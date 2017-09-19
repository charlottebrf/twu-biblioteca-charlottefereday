package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class UserLoginTest {
    String unguessable = "abcdefgh";
    int number = 123-4567;
    Password password = new Password(unguessable);
    LibraryNumber libnum = new LibraryNumber(123-4567);
    UserLogin login = new UserLogin();

    @Before
    public void setUp() {
        login = new UserLogin();
        login.addUserLogin(libnum, password);
    }

    @Test
    public void getsUserLoginDetails() {
        assertEquals(login, login.getUserLogin());
    }

    @Test
    public void getsUserLoginPassword() {
        assertEquals(password, login.getUserLoginPassword(libnum));
    }
}