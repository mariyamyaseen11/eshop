package com.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = -7446162716367847201L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private String name;
	private Double price;
	private Integer quantity;
	private Integer unitsInStock;
	private Boolean isAvailable;
	//private Integer categoryId;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;
	 
	@Lob
	private byte[] productImage;
	
	public Product(Integer id, String description, String name, Double price, Integer quantity, Integer unitsInStock,
			Boolean isAvailable, Category category, byte[] productImage) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.unitsInStock = unitsInStock;
		this.isAvailable = isAvailable;
		this.category= category;
		this.productImage = productImage;
	}
	
	public Product(Integer id, String description, String name, Double price, Integer quantity, byte[] productImage) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.productImage = productImage;
	}
	
	public Product() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getUnitsInStock() {
		return unitsInStock;
	}
	public void setUnitsInStock(Integer unitsInStock) {
		this.unitsInStock = unitsInStock;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public byte[] getProductImage() {
		return productImage;
	}
	public void setProductImage(byte[] productImage) {
		this.productImage = productImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}



}