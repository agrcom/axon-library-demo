package com.daniel.dabrowski.axonlibrary.events;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
@EqualsAndHashCode(callSuper = true)
public class AddedBookEvent extends LibraryBalanceUpdateEvent{

    @TargetAggregateIdentifier
    public String id;
    public String bookName;

    public AddedBookEvent(String bookId, int balance, String id, String bookName) {
        super(bookId, balance);
        this.id = id;
        this.bookName = bookName;
    }
}
