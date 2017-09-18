package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserEmailAddressTest {

    String address = "foo@foo.com";
    UserEmailAddress email = new UserEmailAddress(address);

    @Test
    public void getsUserEmailAddress() {
        assertEquals(address, email.getEmail());
    }
}