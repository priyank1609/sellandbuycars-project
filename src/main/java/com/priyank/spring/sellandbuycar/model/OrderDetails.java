package com.priyank.spring.sellandbuycar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderID;
	private Date orderDate;
	private Date delDate;
	private String status;
	private String address; 
	private String mode;
	
	@ManyToOne
	@JoinColumn(name="user_ID")
	private UserLogin userLogin;
	
	@OneToOne
	@JoinColumn(name="car_ID")
	private CarDetails carDetails;
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserLogin getUserlogin() {
		return userLogin;
	}
	public void setUserlogin(UserLogin userlogin) {
		this.userLogin = userlogin;
	}
	public CarDetails getCarDetails() {
		return carDetails;
	}
	public void setCarDetails(CarDetails carDetails) {
		this.carDetails = carDetails;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	

}
