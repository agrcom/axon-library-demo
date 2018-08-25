package com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class BorrowBookController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public void borrowBook(@RequestBody BorrowBookCommand book) {
        commandGateway.send(book);
    }
}
