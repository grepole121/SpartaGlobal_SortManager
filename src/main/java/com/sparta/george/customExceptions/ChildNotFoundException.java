package com.sparta.george.customExceptions;

public class ChildNotFoundException extends Exception {
    public ChildNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
