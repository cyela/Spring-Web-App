package com.project.model;

import java.io.Serializable;

public class BufCart implements Serializable{
String ProductId,ProductName, email, DateAdded,quantity,price;

public String getProductName() {
	return ProductName;
}

public void setProductName(String productName) {
	ProductName = productName;
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
	ProductId = productId;
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
	DateAdded = dateAdded;
}





public BufCart(String productId, String productName, String email, String dateAdded, String quantity, String price) {
	super();
	ProductId = productId;
	ProductName = productName;
	this.email = email;
	DateAdded = dateAdded;
	this.quantity = quantity;
	this.price = price;
}

public BufCart() {
	super();
}

public BufCart(String email) {
	super();
	this.email = email;
}


	
	
	
}
