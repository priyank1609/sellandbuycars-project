package com.priyank.spring.sellandbuycar.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CarDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int carID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_ID")
	private UserLogin userLogin;
	
	@OneToOne(mappedBy = "carDetails")
	private OrderDetails orderDetails;
	
	
	private String carCompany;
	private String carModel;
	private String condition;
	private String status;
	private String fuelType;
	private int km_driven;
	private int pricing;
	private String approval;
	private String rej_reason;
	private String image;
	
	public int getCarID() {
		return carID;
	}
	public void setCarID(int carID) {
		this.carID = carID;
	}
	
	public String getCarCompany() {
		return carCompany;
	}
	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getKm_driven() {
		return km_driven;
	}
	public void setKm_driven(int km_driven) {
		this.km_driven = km_driven;
	}
	public int getPricing() {
		return pricing;
	}
	public void setPricing(int pricing) {
		this.pricing = pricing;
	}
	public UserLogin getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	public String getRej_reason() {
		return rej_reason;
	}
	public void setRej_reason(String rej_reason) {
		this.rej_reason = rej_reason;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
}
