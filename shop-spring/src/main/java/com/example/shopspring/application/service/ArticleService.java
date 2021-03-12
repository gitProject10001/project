package com.example.shopspring.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.model.domain.Articolo;

public interface ArticleService {

	Integer createArticleV1(String name, BigDecimal price, Integer stock, Integer fkshop);

	Articolo creaArticolo(String name, BigDecimal price, Integer stock, Integer fkshop);

	Articolo trovaArticoloDaId(Integer idarticle);

	List<Articolo> trovaArticoloByStock(Integer stock);

	void updateArticolo(Integer id, Integer incremento);

}