package com.daniel.dabrowski.axonlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Value @AllArgsConstructor
public class AddBookEvent {
    @TargetAggregateIdentifier
    public String id;
    public String bookName;
}
