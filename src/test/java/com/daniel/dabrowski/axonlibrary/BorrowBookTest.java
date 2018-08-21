package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.commands.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.events.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.events.BookBorrowedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

public class BorrowBookTest {

    private FixtureConfiguration<BookAggregate> fixture;

    @Before
    public void setUp() throws Exception {
        fixture = new AggregateTestFixture<>(BookAggregate.class);
    }

    @Test
    public void addBook() {
        fixture.givenNoPriorActivity()
                .when(new AddBookCommand("11", "Test BookAggregate"))
                .expectEvents(new AddedBookEvent("11", "Test BookAggregate", id, bookName));
    }

    @Test
    public void borrowBook() {
        fixture.given(new AddedBookEvent("1234", "Test", id, bookName))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectEvents(new BookBorrowedEvent("1234", "Test", 0));
    }

    @Test
    public void borrowBookWhenLibraryIsEmpty() {
        fixture.given(new AddedBookEvent("1234", "Test", id, bookName),
                new BookBorrowedEvent("1234", "Test", 0))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectNoEvents()
                .expectException(LibraryIsEmptyExpection.class);
    }

    /**
     * //TODO
     * BookProcessor - Listener/component
     * EventHandler BookBorrowed
     *
     * check - QueryHandler 
     */
}
