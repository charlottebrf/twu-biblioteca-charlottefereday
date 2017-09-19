package com.twu.biblioteca;

public class UserLogin {
    final private LibraryNumber libraryNumber;
    final private Password password;

    public UserLogin(LibraryNumber libraryNumber, Password password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public boolean isValid(LibraryNumber libraryNumber2, Password password2) {
        return this.libraryNumber.equals(libraryNumber2) && this.password.equals(password2);
    }

}
