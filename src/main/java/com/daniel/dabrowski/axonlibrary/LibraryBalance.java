package com.daniel.dabrowski.axonlibrary;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.commandhandling.model.EntityId;

@Data
@AllArgsConstructor
public class LibraryBalance {

    @EntityId
    public String id;
    public int balance;
}
