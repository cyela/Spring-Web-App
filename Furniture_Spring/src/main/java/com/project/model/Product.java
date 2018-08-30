package com.project.model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;


public class Product implements Serializable{
	String productId,description,productname,
	productprice,quantity;
	

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductprice() {
		return productprice;
	}

	public void setProductprice(String productprice) {
		this.productprice = productprice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", description=" + description + ", productname=" + productname
				+ ", productprice=" + productprice + ", quantity=" + quantity + ", prodImage="  + "]";
	}

	public Product(String productId, String description, String productname, String productprice, String quantity) {
		super();
		this.productId = productId;
		this.description = description;
		this.productname = productname;
		this.productprice = productprice;
		this.quantity = quantity;
		
	}

	public Product() {
		super();
	}

	public Product(String productId) {
		super();
		this.productId = productId;
	}


	
}
