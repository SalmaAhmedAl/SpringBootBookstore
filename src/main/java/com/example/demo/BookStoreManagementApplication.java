package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication //Component scan
public class BookStoreManagementApplication {

	public static void main(String[] args) {
		 Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

	        // Set system properties for Spring to use
	        System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
	        System.setProperty("DB_PORT", dotenv.get("DB_PORT"));
	        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
	        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(BookStoreManagementApplication.class, args);
	}

}
