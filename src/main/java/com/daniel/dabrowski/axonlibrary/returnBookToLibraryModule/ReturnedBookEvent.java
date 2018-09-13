package com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnedBookEvent {
    public String id;
    public String bookName;
}
