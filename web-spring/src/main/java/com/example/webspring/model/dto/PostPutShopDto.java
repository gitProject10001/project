package com.example.webspring.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class PostPutShopDto {
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
