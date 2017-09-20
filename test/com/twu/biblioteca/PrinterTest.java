package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PrinterTest {
    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }
    java.io.ByteArrayOutputStream outputStream = new java.io.ByteArrayOutputStream();
    Printer printer = new Printer();

    @Test
    public void displaysText() {
        System.setOut(new java.io.PrintStream(outputStream));
        System.out.print("Hello world");
        assertEquals(outputStream.toString(), printer.display("Hello world"));
    }
}