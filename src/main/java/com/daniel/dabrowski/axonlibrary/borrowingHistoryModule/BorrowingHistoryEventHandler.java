package com.daniel.dabrowski.axonlibrary.borrowingHistoryModule;

import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnedBookEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BorrowingHistoryEventHandler {

    protected List<BorrowingHistoryModel> repository;

    @EventHandler
    public void on(AddedBookEvent addedBookEvent){
        repository.add(new BorrowingHistoryModel(addedBookEvent.getId(), addedBookEvent.getBookName(), "Added"));
    }

    @EventHandler
    public void on(BookBorrowedEvent borrowedEvent){
        repository.add(new BorrowingHistoryModel(borrowedEvent.getId(), borrowedEvent.getBookName(), "Borrowed"));
    }

    @EventHandler
    public void on(ReturnedBookEvent returnedBookEvent){
        repository.add(new BorrowingHistoryModel(returnedBookEvent.getId(), returnedBookEvent.getBookName(), "Returned"));
    }
}
