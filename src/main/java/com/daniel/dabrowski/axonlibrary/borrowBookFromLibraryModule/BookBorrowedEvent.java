package com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule;

import com.daniel.dabrowski.axonlibrary.libraryBalanceModule.LibraryBalanceUpdateEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BookBorrowedEvent extends LibraryBalanceUpdateEvent {
    public String id;
    public String bookName;
    public int balance;

    public BookBorrowedEvent(String bookId, int balance) {
        super(bookId, balance);
    }

    public BookBorrowedEvent(String id, String bookName, int balance) {
        this.id = id;
        this.bookName = bookName;
        this.balance = balance;
    }


}
