package com.hiber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderPlaced {

	@Id
	private int orderId;
	private String email;
	private String totalCost;
	private String orderDate;
	private String orderStatus;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
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

	public OrderPlaced(int orderId, String email, String totalCost, String orderDate, String orderStatus) {
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