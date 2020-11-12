package com.javatechie.springsecurityjwt;

import com.javatechie.springsecurityjwt.entity.User;
import com.javatechie.springsecurityjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(1001l, "anna", "$2a$10$YqXQpVejUsZ/qwM8IIc3Mux5beLpZT.vfM0JJdk6fdvun3OlBuhui", "anna@email.com"),
                new User(1002l, "zack", "1234", "zack@email.com"),
                new User(1003l, "john", "1234", "john@email.com"),
                new User(1004l, "brianne", "1234", "brianne@email.com"),
                new User(1005l, "lauren", "1234", "lauren@email.com")
        ).collect(Collectors.toList());

        userRepository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtApplication.class, args);
    }

}
