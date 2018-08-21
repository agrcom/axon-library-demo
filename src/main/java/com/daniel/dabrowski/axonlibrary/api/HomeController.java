package com.daniel.dabrowski.axonlibrary.api;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private CommandGateway commandGateway;

    @GetMapping("/")
    @ResponseBody
    public String home(){

        commandGateway.send(new AddBookCommand("1", "new book"));

        return "OK";
    }
}
