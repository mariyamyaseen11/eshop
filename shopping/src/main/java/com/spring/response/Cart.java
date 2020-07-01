package com.spring.response;

import java.util.Date;

import javax.persistence.Column;

public class Cart {
	private Integer bufcartId;

	private Integer orderId;

	private String email;

	private Date dateAdded;

	private Integer quantity;
	private Double price;
	private Integer productId;
	
	private byte[] productImage;


	private String productname;


	public Integer getBufcartId() {
		return bufcartId;
	}


	public void setBufcartId(Integer bufcartId) {
		this.bufcartId = bufcartId;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}


	public byte[] getProductImage() {
		return productImage;
	}


	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}
	
	
}
