package com.example.shopspring.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.application.ShopspringApplication;
import com.example.shopspring.application.entity.Shop;
import com.example.shopspring.application.repository.ShopRepository;

@SpringBootTest(classes = ShopspringApplication.class)
public class ShopRepositoryTest {
	@Autowired
    private ShopRepository shopRepository;
	@Test
	@Transactional
	public void findAllTest() {
		List<Shop> shops = this.shopRepository.findAll();
		Shop shop = shops.get(0);
		assertNotNull(shop.getName());
		assertNotNull(shop.getEmail());
		
		}
	
	@Test
	@Transactional
	public void saveTest() {
		Shop shop = new Shop();
		shop.setName("Negozio Test");
		shop.setAddress("Address Test");
		shop.setEmail("test@mail.it");
		shop=this.shopRepository.save(shop);
		assertNotNull(shop);
		assertEquals("Negozio Test",shop.getName());
		assertEquals("Address Test",shop.getAddress());
		assertEquals("test@mail.it",shop.getEmail());
		
		
		
	}
	@Test 
	public void findByIdTest() {
		var notFound = this.shopRepository.findById(0);
		//notFound è un Optional di shop
		assertFalse(notFound.isPresent());
		var found = this.shopRepository.findById(1);
		//notFound è un Optional di shop
		assertTrue(found.isPresent());
		var shop = found.get();
		assertEquals(1,shop.getIdshop());
	}

	@Test 
	public void findByNameTest() {
		var notFound = this.shopRepository.findByName("Non Esiste");
		//notFound è un Optional di shop
		assertFalse(notFound.isPresent());
		var found = this.shopRepository.findByName("shop1");
		//notFound è un Optional di shop
		assertTrue(found.isPresent());
		var shop = found.get();
		assertEquals("shop1",shop.getName());
	}

}
