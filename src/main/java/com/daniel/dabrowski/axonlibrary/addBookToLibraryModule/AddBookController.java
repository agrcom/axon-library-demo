package com.daniel.dabrowski.axonlibrary.addBookToLibraryModule;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class AddBookController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping
    public void addBookToShelf(@RequestBody AddBookCommand book){
        commandGateway.send(book);

        System.out.println("Added Book: " + book.getBookName());
    }
}
