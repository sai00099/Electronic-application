package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	private int productId;

	private String modelNumber;

	private String productName;

	private String productCategoryName;

	private LocalDate dateOfPurchase;
	private int warrentyYears;
	private LocalDate warrentyDate;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public int getWarrentyYears() {
		return warrentyYears;
	}
	public void setWarrentyYears(int warrentyYears) {
		this.warrentyYears = warrentyYears;
	}
	public LocalDate getWarrentyDate() {
		return warrentyDate;
	}
	public void setWarrentyDate(LocalDate warrentyDate) {
		this.warrentyDate = warrentyDate;
	}
	public Product(int productId, String modelNumber, String productName, String productCategoryName,
			LocalDate dateOfPurchase, int warrentyYears, LocalDate warrentyDate) {
		super();
		this.productId = productId;
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.productCategoryName = productCategoryName;
		this.dateOfPurchase = dateOfPurchase;
		this.warrentyYears = warrentyYears;
		this.warrentyDate = warrentyDate;
	}
	public Product() {
		super();
	}

}
