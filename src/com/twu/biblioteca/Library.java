package com.twu.biblioteca;
import java.util.*;

public class Library {

    private HashMap<String, ArrayList> setBooks() {
        HashMap<String, ArrayList> booksInLibrary = new  HashMap<String, ArrayList>();
        ArrayList<String> authorAndPublicationYear = new ArrayList<String>();
        authorAndPublicationYear.add("J.K.Rowling");
        authorAndPublicationYear.add("1997");
        booksInLibrary.put("Harry Potter and the Philosopher's Stone", authorAndPublicationYear);
        return booksInLibrary;
    }

    public HashMap<String, ArrayList> getBooks() {
        return this.setBooks();
    }

}
