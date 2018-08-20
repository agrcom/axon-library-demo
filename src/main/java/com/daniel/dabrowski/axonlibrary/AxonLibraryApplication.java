package com.daniel.dabrowski.axonlibrary;

import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.inmemory.InMemoryEventStorageEngine;
import org.axonframework.spring.config.EnableAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableAxon
@SpringBootApplication
public class AxonLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AxonLibraryApplication.class, args);
	}

	@Bean
	public EventStorageEngine eventStorageEngine(){
		return new InMemoryEventStorageEngine();
	}
}


