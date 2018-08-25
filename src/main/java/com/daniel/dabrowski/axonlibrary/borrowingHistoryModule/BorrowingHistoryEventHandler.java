package com.daniel.dabrowski.axonlibrary.borrowingHistoryModule;

import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnBookEvent;
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
    public void on(ReturnBookEvent returnBookEvent){
        repository.add(new BorrowingHistoryModel(returnBookEvent.getId(), returnBookEvent.getBookName(), "Returned"));
    }
}
