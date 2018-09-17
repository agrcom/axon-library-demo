package com.daniel.dabrowski.axonlibrary.addBookToLibraryModule;

import com.daniel.dabrowski.axonlibrary.libraryBalanceModule.LibraryBalanceUpdateEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddedBookEvent extends LibraryBalanceUpdateEvent {

    @TargetAggregateIdentifier
    public String id;
    public String bookName;

    public AddedBookEvent(String bookId) {
        super(bookId);
        this.id = id;
        this.bookName = bookName;
    }

    public AddedBookEvent(String id, String bookName) {
        super();
        this.id = id;
        this.bookName = bookName;
    }
}
