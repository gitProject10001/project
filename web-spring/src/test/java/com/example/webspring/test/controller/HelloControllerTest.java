package com.example.webspring.test.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;

import com.example.shopspring.application.ShopspringApplication;
import com.example.webspring.application.WebspringApplication;
import com.example.webspring.application.controller.HelloController;
@WebMvcTest(controllers = HelloController.class)
@SpringJUnitWebConfig
@ContextConfiguration(classes = {WebspringApplication.class, ShopspringApplication.class})
@AutoConfigureDataJpa

public class HelloControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	public void getGreetTest() throws Exception {
		mockMvc.perform(get("/hello")).andExpect(content().string("Hello World!"));

	}
	
	
}
