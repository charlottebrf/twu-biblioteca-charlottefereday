package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrinterTest {
    @Test
    public void welcomeMessage() {
        Printer display = new Printer();
        String welcome = "Welcome to the new Biblioteca App: we are open for business!";
        assertEquals(welcome, display.getWelcome());
    }
}