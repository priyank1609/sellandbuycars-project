package com.priyank.spring.sellandbuycar.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserLogin {
	@Id
	private String userID;
	private String username;
	private String password;
	private int phone;
	private String email;
	private String address;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@OneToMany(mappedBy = "userLogin",fetch=FetchType.LAZY)
	private List <CarDetails> carDetails;
	
	@OneToMany(mappedBy = "userLogin")
	private List <OrderDetails> orderDetails;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<CarDetails> getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(List<CarDetails> carDetails) {
		this.carDetails = carDetails;
	}
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	

}
