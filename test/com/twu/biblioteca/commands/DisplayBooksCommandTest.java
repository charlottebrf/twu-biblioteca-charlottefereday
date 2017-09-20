package com.twu.biblioteca.commands;

import com.twu.biblioteca.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayBooksCommandTest {
    Library library = new Library();
    Book a = new Book(new BookTitle("aaa"), new Author("bbb"), new Year(1997));

    @Test
    public void listsBooksInLibrary() {
        library.addBooks(a);
        FakePrinter fakePrinter = new FakePrinter();
        DisplayBooksCommand command = new DisplayBooksCommand(library, fakePrinter);
        command.execute();

        assertEquals("|              Book Title               |   Author  | Year|\n|aaa|bbb|1997|\n", fakePrinter.output());

    }

    private class FakePrinter extends Printer {
        private String output = "";

        @Override
        public String display(String stringToBePrinted) {
            output = stringToBePrinted;
            return stringToBePrinted;
        }

        public String output() {
            return output;
        }
    }
}