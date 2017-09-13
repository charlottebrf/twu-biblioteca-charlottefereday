package com.twu.biblioteca;

import com.twu.biblioteca.BibliotecaApp;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    @Test
    public void displaysWelcomeMessage() {
        BibliotecaApp biblioteca = new BibliotecaApp();
        String welcome = "Welcome to the new Biblioteca App: we are open for business!";
        assertEquals(welcome, biblioteca.printWelcome());
    }
}


