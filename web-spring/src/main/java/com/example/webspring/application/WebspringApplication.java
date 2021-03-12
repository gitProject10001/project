package com.example.webspring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.shopspring.application.ShopspringApplication;
// annotation che istruisce spring a riconoscere il package sotto il quale,
// a ombrello, vengono riconosciuti i package di spring
@SpringBootApplication
// annotation per Spring Data JPA
@EnableJpaRepositories
@ComponentScan(basePackageClasses = {ShopspringApplication.class, WebspringApplication.class})
public class WebspringApplication {	
public static void main(String[] args) {
	SpringApplication.run(WebspringApplication.class, args);
}
}
