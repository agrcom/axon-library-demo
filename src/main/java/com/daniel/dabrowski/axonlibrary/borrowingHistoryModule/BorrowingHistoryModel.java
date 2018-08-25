package com.daniel.dabrowski.axonlibrary.borrowingHistoryModule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BorrowingHistoryModel {

    public String id;
    public String bookName;
    public String eventName;
}
