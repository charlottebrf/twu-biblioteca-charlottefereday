package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Map;

import static org.junit.Assert.*;

public class UserLoginTest {

    Password password = new Password("abcdefgh");
    BigInteger cell = new BigInteger("0123456789");
    LibraryNumber libnum = new LibraryNumber(123-4567);
    UserLogin login = new UserLogin();

    @Before
    public void setUp() {
        login = new UserLogin();
    }

    @Test
    public void getsUserLoginDetails() {
        assertEquals(login, login.getUserLogin());
    }

    @Test
    public void checksForUserLibraryNumber() {
        assertEquals(libnum, login.findPasswordFromLibraryNumber());
        }
}