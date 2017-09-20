package com.twu.biblioteca;

public class FakePrinter extends Printer {
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
