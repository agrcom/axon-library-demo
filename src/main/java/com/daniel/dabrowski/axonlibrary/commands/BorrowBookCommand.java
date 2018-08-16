package com.daniel.dabrowski.axonlibrary.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

@Data @AllArgsConstructor
public class BorrowBookCommand {

    @TargetAggregateIdentifier
    public String id;
    public String bookName;

}
