package com.example.webspring.application.controller;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopspring.application.service.ArticleService;
import com.example.shopspring.model.domain.Articolo;
import com.example.webspring.model.dto.PatchArticleDto;
import com.example.webspring.model.dto.PostArticleDto;
import com.example.webspring.model.dto.PostPutShopDto;
import com.example.webspring.model.resource.ArticleResource;
import com.example.webspring.model.resource.ListArticles;
import com.example.webspring.model.resource.ShopResource;

@RequestMapping("/articles")
@RestController
public class ArticleController {
	@Inject
	ArticleService articleService;
	@GetMapping("/{id}")
	public ResponseEntity<ArticleResource> getShop(@PathVariable("id") String id){
		Integer idarticle = Integer.valueOf(id);	
		Articolo articolo = this.articleService.trovaArticoloDaId(idarticle);
		if(articolo==null) {
			return ResponseEntity.notFound().build();
		}
		ArticleResource articleResource = new ArticleResource();
		articleResource.setIdarticle(articolo.getIdarticle());
		articleResource.setName(articolo.getName());
		articleResource.setPrice(articolo.getPrice());
		articleResource.setAvailable(articolo.getStock()>=1);
		return ResponseEntity.ok(articleResource);
	}
	@GetMapping()
	public ResponseEntity<ListArticles> getArticlesStock(@RequestParam("t") String tvalue){
		Integer t = Integer.valueOf(tvalue);
		
		
		List<Articolo> articoli =  articleService.trovaArticoloByStock(t);
		List<ArticleResource> articleResources = new ArrayList<ArticleResource>();
		if(!articoli.isEmpty()) {
		for(var element : articoli) {
    		ArticleResource articoliResource = new ArticleResource();
    		BeanUtils.copyProperties(element,articoliResource);
    		articleResources.add(articoliResource);
    		}
		}
		ListArticles listArticles = new ListArticles();
		listArticles.setArticles(articleResources);
		return  ResponseEntity.ok(listArticles);
	}
	
	
	@PatchMapping()
	public ResponseEntity<?> updateArticle(@Valid @RequestBody  PatchArticleDto patchArticleDto) throws URISyntaxException{
		
		articleService.updateArticolo(patchArticleDto.getIdarticle(),patchArticleDto.getIncrement());
		URI location = new URI("/articles/" + patchArticleDto.getIdarticle());
		return ResponseEntity.created(location).build();
	}
	
	
	
	
	
	
	
	@PostMapping
	 public ResponseEntity<?> postArticle(@Valid @RequestBody PostArticleDto postArticleDto) throws URISyntaxException {
		Integer idArticle = this.articleService.createArticleV1(postArticleDto.getName(),postArticleDto.getPrice(), 0,postArticleDto.getFkShop());
		URI location = new URI("/articles/" + idArticle);
		return ResponseEntity.created(location).build();
	}
	
}


