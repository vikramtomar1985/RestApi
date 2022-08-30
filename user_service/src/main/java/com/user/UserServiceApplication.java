package com.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = { "com.user" })
//@ComponentScan(basePackages = "com.user")
@EnableJpaRepositories("com.user.repository")
//@EnableAutoConfiguration
//@EnableJpaRepositories(basePackages = {"com.user.repository"})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
