package com.daniel.dabrowski.axonlibrary.events;

import lombok.Data;

@Data
public class ReturnBookEvent {
    public String id;
    public String bookName;
}
