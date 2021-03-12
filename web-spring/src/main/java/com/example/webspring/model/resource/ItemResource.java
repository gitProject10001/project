package com.example.webspring.model.resource;

import java.math.BigDecimal;

public class ItemResource {
	private String nome;
	private BigDecimal prezzo;
	private String asin;
	private Boolean disponibile;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	public String getAsin() {
		return asin;
	}
	public void setAsin(String asin) {
		this.asin = asin;
	}
	public Boolean getDisponibile() {
		return disponibile;
	}
	public void setDisponibile(Boolean disponibile) {
		this.disponibile = disponibile;
	}
	

}
