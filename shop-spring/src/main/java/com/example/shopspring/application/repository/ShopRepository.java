package com.example.shopspring.application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.shopspring.application.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
 // scrivo la mia JPQL parametrica:
 // SELECT s FROM Shop s WHERE s.name =?
 // I parametri li chiamo per convenzione con nomi parlanti 
 // restituisco è Optional dell'entity (in questo caso è Optional<hop>)
	@Query("SELECT s FROM Shop s WHERE s.name=?1")
	Optional<Shop> findByName(String name);
}
