package com.twu.biblioteca;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class KeyboardTest {

    public InputStream toStream(String stringy) {
        return new ByteArrayInputStream(stringy.getBytes());
    }

    @Test
    public void canReadInput() {
        Keyboard keyboard = new Keyboard(toStream("book title"));

        assertEquals("book title", keyboard.read());

    }

    @Test
    public void returnsAnEmptyStringIfNoInput() {
        Keyboard keyboard = new Keyboard(toStream(""));

        assertEquals(null, keyboard.read());

    }

    @Test
    public void canReadInputAndReturnAsALibraryNumber() {
        int num = 1234567;
        LibraryNumber libnum = new LibraryNumber(num);
        Keyboard keyboard = new Keyboard(toStream("1234567"));

        assertEquals(libnum.getNumber(), keyboard.readLibraryNumber().getNumber());
    }
}
