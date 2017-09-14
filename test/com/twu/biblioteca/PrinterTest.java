package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PrinterTest {
    Printer printer = new Printer();
    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
    String list = "1. List Books";
    String menu = "Main Menu";

    @Test
    public void welcomeMessage() {
        assertEquals(welcome, printer.getWelcome());
    }

    @Test
    public void mainMenu() {
        assertEquals(list, printer.getmainMenu());
    }

    @Test
    public void printMenuHeader() {
        assertEquals("****" + this.menu + "****" + "\n\n", printer.getMenuHeader());
    }
}