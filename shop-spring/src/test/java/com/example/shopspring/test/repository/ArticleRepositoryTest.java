package com.example.shopspring.test.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import com.example.shopspring.application.ShopspringApplication;
import com.example.shopspring.application.entity.Article;
import com.example.shopspring.application.entity.Shop;
import com.example.shopspring.application.repository.ArticleRepository;

@SpringBootTest(classes=ShopspringApplication.class)
public class ArticleRepositoryTest {
	@Autowired
    private ArticleRepository articleRepository;
	@Test
    public void findAllTest() {
    	List<Article> list = this.articleRepository.findAll();
        Article first = list.get(0);
        assertNotNull(first.getIdarticle());
        assertNotNull(first.getPrice());
        assertNotNull(first.getStock());
        assertNotNull(first.getDatecreated());
        assertNotNull(first.getShop());
        assertNotNull(first.getName());
        
        
    }
	@Test
    @org.springframework.transaction.annotation.Transactional
	public void saveTest() {
		Article art = new Article();
		art.setName("Articolo Test");
		art.setPrice(BigDecimal.TEN);
		art.setStock(100);
		art.setDatecreated(Timestamp.from(Instant.now()));
        art.setDateupdate(null);
        Shop sho = new Shop();
        sho.setIdshop(1);
        art.setShop(sho);
        art = this.articleRepository.save(art);
        assertNotNull(art.getIdarticle());
		
	}
	@Test 
	public void findByIdTest() {
		var notFound = this.articleRepository.findById(0);
		//notFound è un Optional di shop
		assertFalse(notFound.isPresent());
		var found = this.articleRepository.findById(1);
		//notFound è un Optional di shop
		assertTrue(found.isPresent());
		var article = found.get();
		assertEquals(1,article.getIdarticle());
		
	}
	
	
	@Test 
	public void findByNameTest() {
		var notFound = this.articleRepository.findByName("Non Esiste");
		//notFound è un Optional di shop
		assertFalse(notFound.isPresent());
		var found = this.articleRepository.findByName("Articolo Test");
		//notFound è un Optional di shop
		assertTrue(found.isPresent());
		Article article = found.get();
		assertEquals("Articolo Test",article.getName());
	}
	@Test
	public void  findByMaxPriceTest() {
		var maxPrice = BigDecimal.valueOf(100);
		List<Article> articles = this.articleRepository.findByMaxPrice(maxPrice);
		assertFalse(articles.isEmpty());
		
	}
	@Test
	public void  findByMaxPriceNotFoundTest() {
		var maxPrice = BigDecimal.valueOf(0.1);
		List<Article> articles = this.articleRepository.findByMaxPrice(maxPrice);
		assertTrue(articles.isEmpty());
		
	}
	
	
	
	
	
}
