package com.daniel.dabrowski.axonlibrary.libraryBalanceModule;

import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnedBookEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LibraryBalanceEventHandler {

 //   protected List<LibraryBalance> repository;

 //   public LibraryBalanceEventHandler(List<LibraryBalance> repository) {
  //      this.repository = repository;
  //  }

    private LibraryBalance libraryBalance;

//    @EventHandler
//    public void on(LibraryBalanceUpdateEvent event){
//     repository.add(new LibraryBalance(event.getBookId(), event.getBalance()));
//    }

    @EventHandler
    public void on(ReturnedBookEvent event){

    }
}
