package com.twu.biblioteca.commands;

import com.twu.biblioteca.FakePrinter;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExitProgramCommandTest {

    @Test
    public void displaysExitMessage() {
        FakePrinter fakePrinter = new FakePrinter();
        ExitProgramCommand command = new ExitProgramCommand(fakePrinter);
        command.execute();

        assertEquals("You have selected quit: exiting the program now", fakePrinter.output());
    }
}