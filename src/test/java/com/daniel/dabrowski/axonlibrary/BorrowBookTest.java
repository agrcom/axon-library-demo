package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.commands.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.events.AddBookEvent;
import com.daniel.dabrowski.axonlibrary.events.BorrowBookEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Ignore;
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
                .expectEvents(new AddBookEvent("11", "Test BookAggregate"));
    }

    @Test
    public void borrowBook() {
        fixture.given(new AddBookEvent("1234", "Test"))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectEvents(new BorrowBookEvent("1234", "Test", 0));
    }

    @Test @Ignore
    public void borrowBookAndCheckBalance() {
        fixture.given(new AddBookEvent("1234", "Test"),
                new AddBookEvent("1234", "TestBook"))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectEvents(new BorrowBookEvent("1234", "Test", 1));
    }

    @Test
    public void borrowBookWhenLibraryIsEmpty() {
        fixture.given(new AddBookEvent("1234", "Test"),
                new BorrowBookEvent("1234", "Test", 0))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectNoEvents()
                .expectException(LibraryIsEmptyExpection.class);
    }
    //TODO
    /**
     * BookProcessor - Listener/component
     * EventHandler BookBorrowed
     *
     * check - QueryHandler 
     */
}
