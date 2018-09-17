package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnBookCommand;
import com.daniel.dabrowski.axonlibrary.returnBookToLibraryModule.ReturnedBookEvent;
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

    private boolean isBorrowed;

    @CommandHandler
    public BookAggregate(AddBookCommand command) {
        apply(new AddedBookEvent(command.getId(), command.getBookName()));
    }

    @CommandHandler
    public void handle(BorrowBookCommand command) throws BookIsAlreadyBorrowedExpection {
        if (isBorrowed) {
            throw new BookIsAlreadyBorrowedExpection("This Book is Already Borrowed");
        } else {
            apply(new BookBorrowedEvent(bookId, command.getBookName()));
        }
    }

    @CommandHandler
    public void returnBook(ReturnBookCommand command) {
        apply(new ReturnedBookEvent(command.getId(), command.getBookName()));
    }

    @EventSourcingHandler
    public void on(AddedBookEvent event) {
        this.isBorrowed = false;
        this.bookId = event.getId();
    }

    @EventHandler
    public void on(BookBorrowedEvent event) {
        this.isBorrowed = true;
    }

    @EventHandler
    public void on(ReturnedBookEvent event) {
        this.isBorrowed = false;
    }
}
