package com.daniel.dabrowski.axonlibrary.addBookToLibraryModule;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value @AllArgsConstructor
public class AddBookCommand{
        @TargetAggregateIdentifier
        public String id;
        public String bookName;
}
