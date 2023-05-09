package com.citiustech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custid;
	private String name;
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private String phone;
	public Customer( String name, String username, String password, String email, String phone) {
		super();
		//this.custid = custid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getCustid() {
		return custid;
	}
	public void setCustid(Integer custid) {
		this.custid = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
