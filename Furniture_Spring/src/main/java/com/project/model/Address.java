package com.project.model;

import java.io.Serializable;

public class Address implements Serializable{
String address, city, state, zipcode;

String email;

public String getEmail() {
	return email;
}

public Address(String address, String city, String state, String zipcode, String email) {
	super();
	this.address = address;
	this.city = city;
	this.state = state;
	this.zipcode = zipcode;
	this.email = email;
}

public Address(String email) {
	super();
	this.email = email;
}

@Override
public String toString() {
	return "Address [address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", email="
			+ email + "]";
}

public void setEmail(String email) {
	this.email = email;
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
