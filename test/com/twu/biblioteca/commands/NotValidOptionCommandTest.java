package com.twu.biblioteca.commands;

import com.twu.biblioteca.FakePrinter;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotValidOptionCommandTest {

    @Test
    public void displaysNotValidOptionMessage() {
        FakePrinter fakePrinter = new FakePrinter();
        NotValidOptionCommand command = new NotValidOptionCommand(fakePrinter);
        command.execute();

        assertEquals("Select a valid option!", fakePrinter.output());
    }
}