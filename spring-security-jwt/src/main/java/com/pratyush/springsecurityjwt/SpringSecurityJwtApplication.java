package com.pratyush.springsecurityjwt;

import com.pratyush.springsecurityjwt.entity.User;
import com.pratyush.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJwtApplication.class, args);
	}

	@Autowired
	UserRepository repository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				new User(101, "user1", "pass", "user1@gmail.com"),
				new User(102, "user2", "pass", "user2@gmail.com")
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

}
