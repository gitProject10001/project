package com.example.webspring.application.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shopspring.application.service.ShopService;
import com.example.shopspring.model.domain.Negozio;
import com.example.webspring.model.dto.PatchShopDto;
import com.example.webspring.model.dto.PostPutShopDto;
import com.example.webspring.model.resource.ShopResource;

@RequestMapping("/shops")
@RestController
public class ShopsController {
	@Inject
	private ShopService  shopService;
	@GetMapping("/{id}")
public ResponseEntity<ShopResource> getShop(@PathVariable("id") String id){
	Integer idShop = Integer.valueOf(id);	
	Negozio negozio = this.shopService.trovaNegozioDaId(idShop);
	if(negozio==null) {
		return ResponseEntity.notFound().build();
	}
	ShopResource shopResource = new ShopResource();
	shopResource.setIdShop(negozio.getIdshop());
	shopResource.setName(negozio.getName());
	shopResource.setEmail(negozio.getEmail());
	return ResponseEntity.ok(shopResource);
}
	
	
@PostMapping
 public ResponseEntity<?> postShop(@Valid @RequestBody PostPutShopDto postShopDto) throws URISyntaxException{
	Integer newIdShop = this.shopService.createShopV1(postShopDto.getName(), postShopDto.getEmail(), postShopDto.getAddress());
	URI location = new URI("/shops/" + newIdShop);
	return ResponseEntity.created(location).build();
	 
 }

@PutMapping("/{id}")
public ResponseEntity<?> putShop(@PathVariable("id") Integer id,@Valid @RequestBody PostPutShopDto postShopDto) throws URISyntaxException{
	Integer idShop = Integer.valueOf(id);
	Negozio negozio = this.shopService.salvaNegozio(idShop,postShopDto.getName(), postShopDto.getEmail(), postShopDto.getAddress());
	URI location = new URI("/shops/" + idShop);
	return ResponseEntity.ok(negozio);
	 
}
@PatchMapping("/{id}")
public ResponseEntity<ShopResource> patchShop(@PathVariable("id") String id,
                                                     @RequestBody PatchShopDto patchShopDto) throws URISyntaxException{
	
	Integer idShop = Integer.valueOf(id);
	Negozio negozio = this.shopService.aggiornaNegozio(idShop,patchShopDto.getName(), patchShopDto.getEmail(), patchShopDto.getAddress());
	if(negozio==null) {
		return ResponseEntity.notFound().build();
	}
	URI location = new URI("/shops/" + idShop);
	ShopResource shop = new ShopResource();
	BeanUtils.copyProperties(negozio, shop);
	shop.setIdShop(negozio.getIdshop());
	return ResponseEntity.ok(shop);
	
}
	@DeleteMapping("/{id}")
	public ResponseEntity<ShopResource> deleteShop(@PathVariable("id") String id){
	   Integer idShop = Integer.valueOf(id);
	   this.shopService.cancellaNegozio(idShop);
	   return ResponseEntity.noContent().build();
	   
	}
}
	
	
	
	
	
	
	
	
	
	

