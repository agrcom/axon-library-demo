package com.daniel.dabrowski.axonlibrary;


public class BookIsAlreadyBorrowedExpection extends Exception{

    public BookIsAlreadyBorrowedExpection(String message) {
        super(message);
    }
}
