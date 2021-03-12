package com.example.shopspring.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.application.ShopspringApplication;
import com.example.shopspring.application.service.ShopService;
import com.example.shopspring.model.domain.Negozio;
@SpringBootTest(classes = ShopspringApplication.class)
public class ShopServiceTest {
	@Autowired
    private ShopService shopService;
	@Test
	@Transactional
	public void createShopV1Test() {
	  Integer idShop =  this.shopService.createShopV1("Bologna", "b@c.d", null);
	  assertNotNull(idShop);
	}
	@Test
	@Transactional
    public void  creaNegozioTest() {
	var negozio = this.shopService.creaNegozio("Bologna", "c@d.com", "Via Roma");
	assertNotNull(negozio.getIdshop());
	assertEquals("Bologna", negozio.getName());
	assertEquals("c@d.com", negozio.getEmail());
	assertEquals("Via Roma", negozio.getAddress());
    }
	@Test
	public void trovaNegozioDaIdTest() {
		var negozio = this.shopService.trovaNegozioDaId(1);
		assertNotNull(negozio);
		assertEquals(1,negozio.getIdshop());
		
	}
	@Test
    public void trovaNegozioDaIdNotFoundTest() {
		
		var negozio = this.shopService.trovaNegozioDaId(0);
		assertNull(negozio);
	}
}
