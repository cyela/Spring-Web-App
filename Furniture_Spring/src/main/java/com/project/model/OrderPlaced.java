package com.project.model;

import java.io.Serializable;

public class OrderPlaced implements Serializable{

	String orderId,email,totalCost,orderDate,orderStatus;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderPlaced(String orderId, String email, String totalCost, String orderDate, String orderStatus) {
		super();
		this.orderId = orderId;
		this.email = email;
		this.totalCost = totalCost;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
	}

	public OrderPlaced() {
		super();
	}
	
}
