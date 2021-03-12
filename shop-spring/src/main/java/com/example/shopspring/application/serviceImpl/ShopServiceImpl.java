package com.example.shopspring.application.serviceImpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.application.entity.Shop;
import com.example.shopspring.application.repository.ShopRepository;
import com.example.shopspring.application.service.ShopService;
import com.example.shopspring.model.domain.Negozio;
@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopRepository shopRepository;
	@Override
	@Transactional
	public Integer createShopV1(String name,String email,String address) {
		Shop shop = new Shop();
		shop.setName(name);
		shop.setEmail(email);
		shop.setAddress(address);
		
		shop = this.shopRepository.save(shop);
		return shop.getIdshop(); 
		
	}
	// Voglio utilizzare rispetto al metodo prima al fine di poter avere come ritorno il Negozio 
	@Override
	@Transactional
	public Negozio creaNegozio(String name,String email,String address){
		Shop shop = new Shop();
		shop.setName(name);
		shop.setEmail(email);
		shop.setAddress(address);
		
		shop = this.shopRepository.save(shop);
		Negozio negozio = new Negozio();
		BeanUtils.copyProperties(shop, negozio);
		return negozio;
		
	} 
// Nella mia esperienza, i service non restituiscono Optional ma restituiscono direttamente oggetti del domain
// Se l'Optional non ha niente dentro restituisce null.
	
	@Override
	public Negozio trovaNegozioDaId(Integer idshop) {
		var record = this.shopRepository.findById(idshop);
		if(record.isPresent()) {
			var shop = record.get();
			var negozio = new Negozio();
			BeanUtils.copyProperties(shop, negozio);
			return negozio;
		}else {
			return null;
		}
		
	}
	
	
	@Override
	@Transactional
	public Negozio salvaNegozio(Integer idShop,String name,String email,String address) {
		Shop shop = new Shop();
		shop.setIdshop(idShop);
		shop.setName(name);
		shop.setEmail(email);
		shop.setAddress(address);
		
		shop = this.shopRepository.save(shop);
		Negozio negozio = new Negozio();
		BeanUtils.copyProperties(shop, negozio);
		return negozio;
	}
	@Override
	@Transactional
	public Negozio aggiornaNegozio(Integer idShop, String name, String email, String address) {
		Optional<Shop> record =  this.shopRepository.findById(idShop);
		if(!record.isPresent()) {
		return null;
		}
		Shop shop = record.get();
		if(name!=null) {
			shop.setName(name);
		}
		if(email!=null) {
			shop.setEmail(email);
		}
		if(address != null) {
			shop.setAddress(!address.isBlank()? null:address);
		}
		Negozio negozio = new Negozio();
		BeanUtils.copyProperties(shop, negozio);
		return negozio;
	}
	
	@Override
	@Transactional
	public void cancellaNegozio(Integer idShop) {	
		try {
			this.shopRepository.deleteById(idShop);
		} catch (EmptyResultDataAccessException e) {
		       // Do nothing.
		}
//		if(this.shopRepository.existsById(idShop)) {
//			this.shopRepository.deleteById(idShop);
//		}
	}
}
