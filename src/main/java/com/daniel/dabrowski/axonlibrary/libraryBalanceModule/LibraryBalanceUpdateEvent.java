package com.daniel.dabrowski.axonlibrary.libraryBalanceModule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data
public abstract class LibraryBalanceUpdateEvent {
    public String bookId;

}
