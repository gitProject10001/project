package com.example.webspring.model.resource;

import java.math.BigDecimal;

public class ArticleResource {
private Integer idarticle;
private String name;
private Integer stock;
private BigDecimal price;
private Boolean available;
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
public Boolean getAvailable() {
	return available;
}
public void setAvailable(Boolean available) {
	this.available = available;
}
public Integer getStock() {
	return stock;
}
public void setStock(Integer stock) {
	this.stock = stock;
}


}
