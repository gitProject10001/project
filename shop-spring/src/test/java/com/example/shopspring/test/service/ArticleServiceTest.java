package com.example.shopspring.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.application.ShopspringApplication;
import com.example.shopspring.application.service.ArticleService;
import com.example.shopspring.model.domain.Articolo;
import com.example.shopspring.model.domain.Negozio;
@SpringBootTest(classes = ShopspringApplication.class)
public class ArticleServiceTest {
	@Autowired
	private ArticleService articleService;
	@Test
	@Transactional
	public void createArticleV1Test() {
		var idArticle = this.articleService.createArticleV1("Articolo Nome Test", BigDecimal.TEN, 49, 2);
		assertNotNull(idArticle);
	}
	@Test
	@Transactional
	public void creaArticoloTest() {
		Articolo articolo = this.articleService.creaArticolo("Articolo Nome Test", BigDecimal.TEN, 49, 2);
		assertNotNull(articolo.getIdarticle());
		assertEquals("Articolo Nome Test", articolo.getName());
		assertEquals(BigDecimal.TEN, articolo.getPrice());
		assertEquals(49, articolo.getStock());
		assertEquals(0, BigDecimal.TEN.compareTo(articolo.getPrice()));
		}
	
	@Test
	public void trovaArticoloDaIdTest() {
		var articolo = this.articleService.trovaArticoloDaId(1);
		assertNotNull(articolo);
		assertEquals(1,articolo.getIdarticle());
		
	}
	@Test
    public void trovaArticoloDaIdNotFoundTest() {
		
		var articolo = this.articleService.trovaArticoloDaId(0);
		assertNull(articolo);
	}



}
