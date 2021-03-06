package com.daniel.dabrowski.axonlibrary.libraryBalanceModule;

import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnedBookEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryBalanceEventHandler {

    protected List<LibraryBalance> repository;

    public LibraryBalanceEventHandler(List<LibraryBalance> repository) {
        this.repository = repository;
    }

    @EventHandler
    public void on(LibraryBalanceUpdateEvent event){
     repository.add(new LibraryBalance(event.getBookId()));
    }

    @EventHandler
    public void on(ReturnedBookEvent event){
        repository.remove(new LibraryBalance(event.getId()));
    }
}
