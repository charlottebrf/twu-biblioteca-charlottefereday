package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Todo: figure out how to inject to test these console logs
public class PrinterTest {
//    Printer printer = new Printer();
//    String welcome = "Welcome to the new Biblioteca App: we are open for business!";
//    String list = "1. List Books\n2. checkout books\n3. Exit";
//    String menu = "Main Menu";
//
//    @Test
//    public void welcomeMessage() {
//        assertEquals(welcome, printer.getWelcome());
//    }
//
//    @Test
//    public void mainMenu() {
//        assertEquals(list, printer.getMainMenu());
//    }
//
//    @Test
//    public void printMenuHeader() {
//        assertEquals("****" + this.menu + "****" + "\n\n", printer.getMenuHeader());
//    }

//Stackoverflow example of mocking output
//    @Test
//    public void canReadInput() {
//        //Redirect System.out to buffer
//        ByteArrayOutputStream bo = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(bo));
//        MockOut.readInput();
//        bo.flush();
//        String allWrittenLines = new String(bo.toByteArray());
//        assertTrue(allWrittenLines.contains("did it!"));
//
//        assertEquals();
//
//    }
}