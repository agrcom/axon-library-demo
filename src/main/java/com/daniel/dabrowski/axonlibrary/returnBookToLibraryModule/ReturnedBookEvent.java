package com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReturnedBookEvent {
    private String id;
    private String bookName;
}
