package com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shelf")
public class ReturnBookController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/return")
    public void returnBook(@RequestBody ReturnBookCommand book) {
        commandGateway.send(book);
    }
}
