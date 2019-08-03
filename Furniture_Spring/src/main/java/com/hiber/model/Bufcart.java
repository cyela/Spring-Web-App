package com.hiber.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bufcart {

	@Id
	private int bufcartId;

	@Column(nullable = true)
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public int getBufcartId() {
		return bufcartId;
	}

	public void setBufcartId(int bufcartId) {
		this.bufcartId = bufcartId;
	}

	private String ProductId, ProductName, email, DateAdded, quantity, price;

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		this.ProductName = productName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductId() {
		return ProductId;
	}

	public void setProductId(String productId) {
		this.ProductId = productId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateAdded() {
		return DateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.DateAdded = dateAdded;
	}

	public Bufcart(String productId, String productName, String email, String dateAdded, String quantity,
			String price) {
		super();
		this.ProductId = productId;
		this.ProductName = productName;
		this.email = email;
		this.DateAdded = dateAdded;
		this.quantity = quantity;
		this.price = price;
	}

	public Bufcart() {
		super();
	}

	public Bufcart(String email) {
		super();
		this.email = email;
	}
}