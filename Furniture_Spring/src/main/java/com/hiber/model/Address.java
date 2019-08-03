package com.hiber.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private String email;
	private String address;
	private String city;
	private String zipcode;
	private String state;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address(String address, String city, String state, String zipcode) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", email=" + "]";
	}

	public Address() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}