package com.daniel.dabrowski.axonlibrary.e2e;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class BorrowingHistoryTest extends TestBase{

    //@formatter:off


    @Test
    public void getCompletedHistory(){
        addBookToShelf("1", "CleanCode");
        addBookToShelf("2", "Green Mile");
        addBookToShelf("3", "Effective Java");

        given()
                .contentType(ContentType.JSON)
                .when()
                .get("/book/")
                .then()
                .statusCode(200);
    }

    @Test
    public void getBookHistory(){
        addBookToShelf("1", "CleanCode");

        borrowBook("1", "CleanCode");
        returnBook("1", "CleanCode");

        given()
            .contentType(ContentType.JSON)
        .when()
            .get("/book/1")
        .then()
            .statusCode(200);


    }

    //@formatter:on
}