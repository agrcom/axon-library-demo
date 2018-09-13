package com.daniel.dabrowski.axonlibrary;


public class LibraryIsEmptyExpection extends Exception{

    public LibraryIsEmptyExpection(String message) {
        super(message);
    }
}
