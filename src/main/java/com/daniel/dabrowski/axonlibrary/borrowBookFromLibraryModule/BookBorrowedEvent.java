package com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule;

import com.daniel.dabrowski.axonlibrary.libraryBalanceModule.LibraryBalanceUpdateEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookBorrowedEvent extends LibraryBalanceUpdateEvent {
    public String id;
    public String bookName;

    public BookBorrowedEvent(String bookId) {
        super(bookId);
    }

    public BookBorrowedEvent(String id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }


}
