package com.daniel.dabrowski.axonlibrary.unit;

import com.daniel.dabrowski.axonlibrary.BookAggregate;
import com.daniel.dabrowski.axonlibrary.LibraryIsEmptyExpection;
import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddBookCommand;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BorrowBookCommand;
import com.daniel.dabrowski.axonlibrary.addBookToLibraryModule.AddedBookEvent;
import com.daniel.dabrowski.axonlibrary.borrowBookFromLibraryModule.BookBorrowedEvent;
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
                .expectEvents(new AddedBookEvent("11", "Test BookAggregate"));
    }

    @Test
    public void borrowBook() {
        fixture.given(new AddedBookEvent("1234", "Test"))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectEvents(new BookBorrowedEvent("1234", "Test", 0));
    }

    @Test
    public void borrowBookWhenLibraryIsEmpty() {
        fixture.given(new AddedBookEvent("1234", "Test"),
                new BookBorrowedEvent("1234", "Test", 0))
                .when(new BorrowBookCommand("1234", "Test"))
                .expectNoEvents()
                .expectException(LibraryIsEmptyExpection.class);
    }

    /**
     * //TODO
     * BookProcessor - Listener/component
     * EventHandler BookBorrowed
     */
}
