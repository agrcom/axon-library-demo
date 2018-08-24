package com.daniel.dabrowski.axonlibrary.libraryBalanceModule;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/balance")
public class LibraryBalanceController extends LibraryBalanceEventHandler{

    public LibraryBalanceController(List<LibraryBalance> repository) {
        super(repository);
    }

    @GetMapping("/{id}")
    public LibraryBalance getBalance(@PathVariable int id){

        return repository.get(id);
    }
}
