package com.example.shopspring.application.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.shopspring.application.entity.Article;
import com.example.shopspring.application.entity.Shop;

public interface ArticleRepository extends JpaRepository<Article, Integer>{
	@Query("SELECT a FROM Article a WHERE a.name=?1")
	Optional<Article> findByName(String name);
	@Query("SELECT a FROM Article a WHERE a.price<?1")
	List<Article> findByMaxPrice(BigDecimal maxPrice);
	
	@Query("SELECT a FROM Article a WHERE a.stock<?1")
	List<Article> findByStock(Integer stock);
	
	@Modifying
	@Query("update Article a set a.stock = :newStock where a.id = :id")
	void updateArticolo(@Param("id") Integer id, @Param("newStock") Integer newStock);
}
