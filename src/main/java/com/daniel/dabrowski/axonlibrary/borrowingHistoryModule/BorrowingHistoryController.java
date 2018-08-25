package com.daniel.dabrowski.axonlibrary.borrowingHistoryModule;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
public class BorrowingHistoryController extends BorrowingHistoryEventHandler {

    @GetMapping("/")
    public List<BorrowingHistoryModel> getCompletedHistory(){
        return repository;
    }

    @GetMapping("/{id}")
    public BorrowingHistoryModel getBookHistory(@PathVariable int id){
        return repository.get(id);
    }
}
