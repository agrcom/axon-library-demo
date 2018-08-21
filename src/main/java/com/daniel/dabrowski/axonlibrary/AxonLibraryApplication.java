package com.daniel.dabrowski.axonlibrary;

import com.daniel.dabrowski.axonlibrary.commands.AddBookCommand;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@EnableAxon
@SpringBootApplication
public class AxonLibraryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(AxonLibraryApplication.class, args);
		CommandBus commandBus = config.getBean(CommandBus.class);
		commandBus.dispatch(GenericCommandMessage.asCommandMessage(new AddBookCommand("1", "Clean Code")));
	}

	@Bean
	public EventStorageEngine eventStorageEngine(){
		return new InMemoryEventStorageEngine();
	}
}


