package com.daniel.dabrowski.axonlibrary.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class BorrowBookEvent {
    public String id;
    public String bookName;
}
