package com.acn.spring.boot.intro;

import com.acn.spring.boot.intro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootIntroApplication implements CommandLineRunner {

	private final UserService service;

	public SpringBootIntroApplication(@Autowired UserService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntroApplication.class, args);
	}

	@Override
	public void run(String... args) {
		service.addUser("Ruben", "te Wierik");
		service.addUser("Phoenix", "Wright");

		service.getUser(1);
		service.getUser(2);

		service.removeUser(1);
		service.removeUser(2);

		service.getUser(1);
	}
}
