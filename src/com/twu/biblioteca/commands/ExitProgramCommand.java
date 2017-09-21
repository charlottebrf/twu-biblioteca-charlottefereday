package com.twu.biblioteca.commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Printer;

public class ExitProgramCommand implements Command {

    private Printer printer;

    public ExitProgramCommand(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.display("You have selected quit: exiting the program now");
        System.exit(0);
        return;
    }
}
