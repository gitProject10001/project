package com.example.webspring.model.resource;

import java.math.BigDecimal;

public class PersonResource {
private String nome;
private String cognome;
private Integer eta;
private BigDecimal altezza;
private Boolean statoLibero;

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public Integer getEta() {
	return eta;
}
public void setEta(Integer eta) {
	this.eta = eta;
}
public BigDecimal getAltezza() {
	return altezza;
}
public void setAltezza(BigDecimal altezza) {
	this.altezza = altezza;
}
public Boolean getStatoLibero() {
	return statoLibero;
}
public void setStatoLibero(Boolean statoLibero) {
	this.statoLibero = statoLibero;
}

}
