package com.hiber.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String salt;
	private String gender;
	private String phonenumber;
	private String birthdate;
	private Blob image;

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDOB() {
		return birthdate;
	}

	public void setDOB(String dOB) {
		birthdate = dOB;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Admin(String email) {
		super();
		this.email = email;
	}

	public Admin() {
		super();
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", salt=" + salt + ", gender=" + gender + ", phonenumber=" + phonenumber + ", DOB=" + birthdate + "]";
	}

}