package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Keyboard {

    private final BufferedReader reader;

    public Keyboard() {
        this(System.in);
    }

    public Keyboard(InputStream in) {
        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    public String read() {
        String returnedBook = "";
        try {
            returnedBook = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnedBook;
    }

    public LibraryNumber readLibraryNumber() {
        int number = 0;
        try {
            String line = reader.readLine();
            number = Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Not recognized: try again");
            readLibraryNumber();
        }
        return new LibraryNumber(number);
    }

    public Password readPassword() {
        String password = "";
        try {
            password = reader.readLine();
        } catch (IOException | NumberFormatException e) {
            System.out.println("Not recognized: try again");
            readPassword();
        }
        return new Password(password);
    }

}
