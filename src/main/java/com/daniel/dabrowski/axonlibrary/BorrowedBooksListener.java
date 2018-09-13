package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class BorrowedBooksListener {

    @EventHandler
    public void on(BookBorrowedEvent event){
        //counter
    }

//    @QueryHandler
//    public BorrowedBooksCountReply query(BorrowedBooksCountQuery borrowedBooksCountQuery){
//        return BorrowedBooksCountReply(counter)
//    }
}
