package com.example.webspring.model.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PostArticleDto {
	
	private String name;
	@NotNull
	@Positive
	private BigDecimal price;
	@NotNull
	private Integer fkShop;
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
	public Integer getFkShop() {
		return fkShop;
	}
	public void setFkShop(Integer fkShop) {
		this.fkShop = fkShop;
	}
}
