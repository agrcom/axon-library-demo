package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.events.LibraryBalanceUpdateEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class LibraryBalanceEventHandler {

    @EventHandler
    public void on(LibraryBalanceUpdateEvent event){
     //in training was configured jpa here, I have to use some collection...
    }
}
