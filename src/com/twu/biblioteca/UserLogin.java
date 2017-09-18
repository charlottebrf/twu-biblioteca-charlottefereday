package com.twu.biblioteca;

import java.math.BigInteger;
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

    public Password getUserLoginPassword(BigInteger number) { return userLogin.get(number);}

}
