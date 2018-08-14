package com.daniel.dabrowski.axonlibrary.commands;

import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data
public class BorrowBookCommand {
    @TargetAggregateIdentifier
    public String id;
    public String bookName;
}
