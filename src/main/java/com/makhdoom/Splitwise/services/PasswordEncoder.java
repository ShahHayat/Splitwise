package com.makhdoom.Splitwise.services;

public interface PasswordEncoder {

    String encode(String password);
    boolean matches(String plaintext, String hashedPassword);
}
