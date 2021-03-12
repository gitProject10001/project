package com.example.webspring.application.controller;

import javax.servlet.annotation.HttpMethodConstraint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hello")
@RestController
public class HelloController {
@GetMapping
	public String getGreet() {
		return "Hello World!";
	}
	
}
