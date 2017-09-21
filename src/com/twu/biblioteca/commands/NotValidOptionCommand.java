package com.twu.biblioteca.commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Printer;

public class NotValidOptionCommand implements Command {

    private Printer printer;

    public NotValidOptionCommand(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.display("Select a valid option!");
    }

    @Override
    public String intent() {
        return "Not implemented";
    }
}
