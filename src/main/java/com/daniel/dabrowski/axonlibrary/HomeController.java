package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddBookCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.CompletableFuture;

@Controller
public class HomeController {

    @Autowired
    private CommandGateway commandGateway;
    private QueryGateway queryGateway;


    @GetMapping("/")
    @ResponseBody
    public String home(){
        commandGateway.send(new AddBookCommand("1", "new book"));

        return "OK";
    }

//    @RequestMapping("/borrowed")
//    public CompletableFuture<> getBorrowedBooksList(){
//        BorrowedBooksCountQuery borrowedBooksCountQuery = new BorrowedBooksCountQuery();
//        CompletableFuture<BorrowedBooksCountReply> query =
//                queryGateway.query(borrowedBooksCountQuery, BorrowedBooksCountReply.class );
//        return query.thenApply(BorrowedBooksCountReply::getValue); //powinno być getCount
//    }
}


//TODO
// endpoint for borrow book
// endpoint for return
// count and polish query
