package com.daniel.dabrowski.axonlibrary.e2e;


import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LibraryBalanceTest extends TestBase{

    //@formatter:off

    @Test
    public void addBookToShelf() {
        addBookToShelf("1", "Green Mile");
    }

    @Test
    public void borrowBook() {

        addBookToShelf("1", "Green Mile");
        borrowBook("1", "Green Mile");
    }
    //@formatter:on
}
