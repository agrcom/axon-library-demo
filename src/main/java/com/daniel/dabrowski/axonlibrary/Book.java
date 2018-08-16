package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.commands.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.events.AddBookEvent;
import com.daniel.dabrowski.axonlibrary.events.BorrowBookEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
public class Book {

    @AggregateIdentifier
    private String bookId;
    private int balance;

    @CommandHandler
    public Book(AddBookCommand command) {
        apply(new AddBookEvent(command.getId(), command.getBookName()));
    }

    @CommandHandler
    public void handle(BorrowBookCommand command) throws LibraryIsEmptyExpection {
        if(balance>0) {
            apply(new BorrowBookEvent(bookId, command.getBookName(), balance));
        }else {
            throw new LibraryIsEmptyExpection();
        }
    }

    @EventSourcingHandler
    public void on(AddBookEvent event){
        this.bookId = event.getId();
        this.balance =+ 1;
    }

    @EventSourcingHandler
    public void on(BorrowBookEvent event){
        this.balance = this.balance - 1;
        event.setBalance(this.balance);
    }
}
