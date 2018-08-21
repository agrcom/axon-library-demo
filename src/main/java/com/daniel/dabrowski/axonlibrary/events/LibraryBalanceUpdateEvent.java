package com.daniel.dabrowski.axonlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor @Data
public abstract class LibraryBalanceUpdateEvent {
    public String bookId;
    public int balance;
}
