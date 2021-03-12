package com.example.shopspring.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.example.shopspring.model.domain.Negozio;

public interface ShopService {

	Integer createShopV1(String name, String email, String address);

	Negozio creaNegozio(String name, String email, String address);

	Negozio trovaNegozioDaId(Integer idshop);

	Negozio salvaNegozio(Integer idShop, String name, String email, String address);

	Negozio aggiornaNegozio(Integer idShop, String name, String email, String address);

	void cancellaNegozio(Integer idShop);

}