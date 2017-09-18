package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class UserAccountTest {
    LibraryNumber libnum = new LibraryNumber(123-4567);
    Password password = new Password("abcdefgh");
    UserName userName = new UserName("Charlotte Fereday");
    UserEmailAddress email = new UserEmailAddress("foo@foo.com");
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);

    UserAccount account = new UserAccount(libnum, password, userName, email, number);

    @Before
    public void setUp() throws Exception {
        account = new UserAccount(libnum, password, userName, email, number);
    }

    @Test
    public void getsAUserAccount() {
        assertEquals(account, account.getUserAccount());
    }
}