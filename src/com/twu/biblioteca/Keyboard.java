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
}
