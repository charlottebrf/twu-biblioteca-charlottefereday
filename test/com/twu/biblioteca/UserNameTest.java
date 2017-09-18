package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserNameTest {
    String name = "Charlotte Fereday";
    UserName customer = new UserName(name);

    @Test
    public void getsUserName() {
        assertEquals(name, customer.getUserName());
    }
}