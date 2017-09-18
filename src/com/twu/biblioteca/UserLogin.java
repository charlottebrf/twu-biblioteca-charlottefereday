package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class UserLogin {
    final private Map<LibraryNumber, Password> userLogin;

    public UserLogin() {
        userLogin = new HashMap<LibraryNumber, Password>();
    }

    public void addUserLogin(LibraryNumber libraryNumber, Password password) {
        userLogin.put(libraryNumber, password);
    }

    public UserLogin getUserLogin() {
        return this;
    }


//    public int findLibraryNumberFromNumber(LibraryNumber libraryNumber) {
//        if
//        return userLogin.getOrDefault(libraryNumber.getNumber(),);
//    }


}
