package com.daniel.dabrowski.axonlibrary.e2e;

import groovy.json.internal.LazyMap;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class TestBase {

    @Before
    public void setup() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 8080;
    }

    public ValidatableResponse addBookToShelf(String id, String bookTitle){
        return given()
                .body(generateBookBody(id, bookTitle))
                .contentType(ContentType.JSON)
            .when()
                .post("/shelf/addBook")
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void returnBook(String id, String bookTitle) {

    }

    public void borrowBook(String id, String bookTitle) {
    }


    private LazyMap generateBookBody(String id, String bookTitle) {
        LazyMap lazyMap = new LazyMap();
        lazyMap.put("id", id);
        lazyMap.put("bookName", bookTitle);
        return lazyMap;
    }
}
