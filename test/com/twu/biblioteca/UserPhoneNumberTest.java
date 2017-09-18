package com.twu.biblioteca;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class UserPhoneNumberTest {
    BigInteger cell = new BigInteger("0123456789");
    UserPhoneNumber number = new UserPhoneNumber(cell);

    @Test
    public void getsUserPhoneNumber() {
        assertEquals(cell, number.getNumber());
    }
}