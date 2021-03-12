package com.example.shopspring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableJpaRepositories
public class ShopspringApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopspringApplication.class, args);
	}

}
