package com.twu.biblioteca.commands;

import com.twu.biblioteca.Command;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Printer;

public class DisplayBooksCommand implements Command {

    private final Library library;
    private final Printer printer;

    public DisplayBooksCommand(Library library, Printer printer) {
        this.library = library;
        this.printer = printer;
    }

    @Override
    public void execute() {
        String header = "|              Book Title               |   Author  | Year|\n";
        printer.display(header + library.getBookDetails());
    }

    @Override
    public String intent() {
        return "Display books";
    }
}
