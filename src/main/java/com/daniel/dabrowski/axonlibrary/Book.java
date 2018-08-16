package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.events.AddBookEvent;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@NoArgsConstructor
public class Book {

    @AggregateIdentifier
    private String bookId;

    @CommandHandler
    public Book(AddBookCommand command) {
        apply(new AddBookEvent(command.getId(), command.getBookName()));
    }

    @EventSourcingHandler
    public void on(AddBookEvent event){
        this.bookId = event.getId();
    }
}
