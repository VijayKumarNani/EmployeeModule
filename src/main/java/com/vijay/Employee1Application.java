package com.vijay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Employee1Application {

	public static void main(String[] args) {
		SpringApplication.run(Employee1Application.class, args);
	}

}
