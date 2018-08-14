package com.daniel.dabrowski.axonlibrary.events;

import lombok.Data;

@Data
public class BorrowBookEvent {
    public String id;
    public String bookName;
}
