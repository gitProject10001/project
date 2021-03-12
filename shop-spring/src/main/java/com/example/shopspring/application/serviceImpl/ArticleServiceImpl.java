package com.example.shopspring.application.serviceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.application.entity.Article;
import com.example.shopspring.application.repository.ArticleRepository;
import com.example.shopspring.application.repository.ShopRepository;
import com.example.shopspring.application.service.ArticleService;
import com.example.shopspring.model.domain.Articolo;
import com.example.shopspring.model.domain.Negozio;


@Service
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ShopRepository shopRepository;
    @Override
	@Transactional
	public Integer createArticleV1(String name, BigDecimal price, Integer stock, Integer fkshop) {
		var dateCreated = Timestamp.from(Instant.now());
		
		var shop = this.shopRepository.getOne(fkshop);
		var article = new Article();
		article.setName(name);
		article.setPrice(price);
		article.setStock(stock);
		article.setShop(shop);
		article.setDatecreated(dateCreated);
		article = this.articleRepository.save(article);
		
		return article.getIdarticle();

	}
    @Override
    @Transactional
	public Articolo creaArticolo(String name, BigDecimal price, Integer stock, Integer fkshop) {
        
    	var dateCreated = Timestamp.from(Instant.now());
		var shop = this.shopRepository.getOne(fkshop);
		var article = new Article();
		article.setName(name);
		article.setPrice(price);
		article.setStock(stock);
		article.setShop(shop);
		article.setDatecreated(dateCreated);
		article = this.articleRepository.save(article);
		return this.convertArticle(article);
		
	}
    @Override
	public Articolo trovaArticoloDaId(Integer idarticle) {
    	var record = this.articleRepository.findById(idarticle);
		if(record.isPresent()) {
			var article = record.get();
			var articolo = new Articolo();
			BeanUtils.copyProperties(article, articolo);
			return articolo;
		}else {
			return null;
		}
    }

    
    private  Articolo convertArticle(Article article) {
    	Articolo articolo = new Articolo();
    	articolo.setIdarticle(article.getIdarticle());
    	articolo.setName(article.getName());
    	articolo.setPrice(article.getPrice());
    	articolo.setStock(article.getStock());
    	return articolo;
    }
    
    @Override
	public List<Articolo> trovaArticoloByStock(Integer stock){
    	
    	List<Article> articles = articleRepository.findByStock(stock);
    	List<Articolo> articoli = new ArrayList<Articolo>();
    	if(!articles.isEmpty()) {
    	for(var element : articles) {
    		Articolo articolo = new Articolo();
    		BeanUtils.copyProperties(element, articolo);
    		articoli.add(articolo);
    		}
    	}
    	return articoli;
    }
    @Transactional
    @Override
	public void updateArticolo(Integer id, Integer incremento) {
    	
    	Optional<Article> optional = articleRepository.findById(id);
    	if(!optional.isPresent()) {
    		return;
    	}
       Article article = optional.get();
       article.setStock(article.getStock()+incremento);
       articleRepository.updateArticolo(id, article.getStock());
       Articolo articolo = new Articolo();
       BeanUtils.copyProperties(article, articolo);
       
    	
    }

}
