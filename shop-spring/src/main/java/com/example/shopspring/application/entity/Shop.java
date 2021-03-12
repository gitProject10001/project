package com.example.shopspring.application.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the shop database table.
 * 
 */
@Entity
@Table(name="shops")
@NamedQuery(name="Shop.findAll", query="SELECT s FROM Shop s")
public class Shop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idshop;

	private String address;

	private String email;

	private String name;

	//bi-directional many-to-one association to Article
	@OneToMany(mappedBy="shop")
	private List<Article> articles;

	public Shop() {
	}

	public Integer getIdshop() {
		return this.idshop;
	}

	public void setIdshop(Integer idshop) {
		this.idshop = idshop;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setShop(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setShop(null);

		return article;
	}

}