package com.sparta.george.customExceptions;

public class SorterNotFoundException extends Exception {
    public SorterNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
