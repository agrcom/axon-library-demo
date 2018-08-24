package com.daniel.dabrowski.axonlibrary.e2e;


import groovy.json.internal.LazyMap;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LibraryBalanceTest {

    @Test
    public void addBookAndBorrowIt() {
        LazyMap basic = new LazyMap();
        basic.put("id", "1");
        basic.put("bookName", "Test Book");

        given()
            .body(basic)
            .contentType(ContentType.JSON)
        .when()
            .post("")
        .then()
            .statusCode(HttpStatus.SC_OK);
    }
}
