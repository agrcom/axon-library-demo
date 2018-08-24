package com.daniel.dabrowski.axonlibrary.e2e;


import groovy.json.internal.LazyMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LibraryBalanceTest {

    //@formatter:off
    @Before
    public void setup() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void addBookToShelf() {
        LazyMap basic = new LazyMap();
        basic.put("id", "1");
        basic.put("bookName", "Test Book");

        given()
            .body(basic)
            .contentType(ContentType.JSON)
        .when()
            .post("/shelf/addBook")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void borrowBook() {
        LazyMap basic = new LazyMap();
        basic.put("id", "1");
        basic.put("bookName", "Test Book");

        given()
            .body(basic)
            .contentType(ContentType.JSON)
        .when()
            .post("/shelf/addBook")
        .then()
            .statusCode(HttpStatus.SC_OK);

        given()
            .body(basic)
            .contentType(ContentType.JSON)
                .when()
        .post("/shelf/borrowBook")
                .then()
        .statusCode(HttpStatus.SC_OK);

    }
    //@formatter:on
}
