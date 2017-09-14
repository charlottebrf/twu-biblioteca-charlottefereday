package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrinterTest {
    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    Printer printer = new Printer();

    @Test
    public void welcomeMessage() {
        assertEquals(welcome, printer.getWelcome());
    }
}