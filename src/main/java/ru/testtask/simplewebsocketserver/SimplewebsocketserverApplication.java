package ru.testtask.simplewebsocketserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SimplewebsocketserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplewebsocketserverApplication.class, args);
	}

}
