package com.example.webspring.application.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webspring.model.resource.PersonResource;

@RequestMapping("/person")
@RestController
public class PersonController {
	@GetMapping
	public PersonResource getPerson() {
		PersonResource personResource = new PersonResource();
		personResource.setNome("Luca");
		personResource.setCognome("Anderlini");
		personResource.setEta(29);
		personResource.setAltezza(BigDecimal.valueOf(1.79));
		personResource.setStatoLibero(true);
		return personResource;
	}
}
