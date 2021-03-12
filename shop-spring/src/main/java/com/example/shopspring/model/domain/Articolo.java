package com.example.shopspring.model.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Articolo {
	
    private Integer idarticle;

    private String name;

	private BigDecimal price;

	private Integer stock;

	public Integer getIdarticle() {
		return idarticle;
	}

	public void setIdarticle(Integer idarticle) {
		this.idarticle = idarticle;
	}

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
