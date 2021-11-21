package com.jdmp.aldeamo.exceptions;


public class CustomExeption extends RuntimeException {
    private String message;
    public CustomExeption(String message) {
        super(message);
        this.message = message;
    }
    public CustomExeption() {
    }

}
