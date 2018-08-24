package com.daniel.dabrowski.axonlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data
public abstract class LibraryBalanceUpdateEvent {
    public String bookId;
    public int balance;


    public LibraryBalanceUpdateEvent() {
    }
}
