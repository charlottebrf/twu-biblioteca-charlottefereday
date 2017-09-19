package com.twu.biblioteca;


public class LibraryNumber {
    private final int number;

    public LibraryNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public boolean equals(Object aLibraryNumber) {
        LibraryNumber lN = (LibraryNumber) aLibraryNumber;
        return getNumber() == lN.getNumber();
    }
}
