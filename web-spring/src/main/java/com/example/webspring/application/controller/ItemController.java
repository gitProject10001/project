package com.example.webspring.application.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webspring.model.resource.ItemResource;

@RequestMapping("/item")
@RestController
public class ItemController {
	@GetMapping 
    public ItemResource getItem() {
	 ItemResource itemResource = new ItemResource();
	 itemResource.setNome("Bastone da passeggio");
   	 itemResource.setPrezzo(BigDecimal.valueOf( 14.99));
	 itemResource.setAsin("asin1368226");
	 itemResource.setDisponibile(true);
	 return itemResource;
	
}
}
