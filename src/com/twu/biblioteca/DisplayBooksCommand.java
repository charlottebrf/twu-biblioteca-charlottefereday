package com.twu.biblioteca;

public class DisplayBooksCommand implements Command {
    Library library;
    Printer printer;
    DisplayBooks displayBooks;

    public void displayBooks() {
        String header = "|              Book Title               |   Author  | Year|\n";
        printer.display(header + library.getBookDetails());
    }

}
