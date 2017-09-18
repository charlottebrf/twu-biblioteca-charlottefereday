package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {
    String secure = "abcdefgh";
    Password password = new Password(secure);

    @Test
    public void getsPassword() {
        assertEquals(secure, password.getPassword());
    }
}