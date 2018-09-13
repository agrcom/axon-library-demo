package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
@NoArgsConstructor
public class BookAggregate {

    @AggregateIdentifier
    private String bookId;
    private int balance;

    private boolean isBorrowed;

    @CommandHandler
    public BookAggregate(AddBookCommand command) {
        apply(new AddedBookEvent(command.getId(), command.getBookName()));
    }

    @CommandHandler
    public void handle(BorrowBookCommand command) throws LibraryIsEmptyExpection {
        if(balance>0) {
            apply(new BookBorrowedEvent(bookId, command.getBookName(), balance));
        }else {
            throw new LibraryIsEmptyExpection("error");
        }
    }

    @EventSourcingHandler
    public void on(AddedBookEvent event){
        this.isBorrowed = false;
        this.bookId = event.getId();
        this.balance =+ 1;
    }

    @EventHandler
    public void on(BookBorrowedEvent event){
        this.isBorrowed = true;
        this.balance = this.balance - 1;
        event.setBalance(this.balance);
    }
}
//TODO add command handler for return