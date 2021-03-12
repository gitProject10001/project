package com.example.shopspring.application.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the articles database table.
 * 
 */

@Entity
@Table(name="articles")
@NamedQuery(name="Article.findAll", query="SELECT a FROM Article a")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idarticle;

	private Timestamp datecreated;

	private Timestamp dateupdate;

	private String name;

	private BigDecimal price;

	private Integer stock;

	//bi-directional many-to-one association to Shop
	@ManyToOne
	@JoinColumn(name="fkshop")
	private Shop shop;

	public Article() {
	}

	public Integer getIdarticle() {
		return this.idarticle;
	}

	public void setIdarticle(Integer idarticle) {
		this.idarticle = idarticle;
	}

	public Timestamp getDatecreated() {
		return this.datecreated;
	}

	public void setDatecreated(Timestamp datecreated) {
		this.datecreated = datecreated;
	}

	public Timestamp getDateupdate() {
		return this.dateupdate;
	}

	public void setDateupdate(Timestamp dateupdate) {
		this.dateupdate = dateupdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getStock() {
		return this.stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

}