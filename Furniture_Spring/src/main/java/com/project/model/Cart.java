package com.project.model;

import java.io.Serializable;

public class Cart implements Serializable{
	
	
	String productId,quantity,dateAdded,orderId,price;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Cart(String productId, String quantity, String dateAdded, String orderId, String price) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.dateAdded = dateAdded;
		this.orderId = orderId;
		this.price = price;
	}

	public Cart() {
		super();
	}
	
	
	
}
