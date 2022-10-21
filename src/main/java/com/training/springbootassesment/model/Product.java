package com.training.springbootassesment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Product")
public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prod_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int prodId;
	
	@Column(name="prod_name")
	private String prodName;
	
	@Column(name="prod_type")
	private String prodType;
	
	@Column(name="prod_price")
	private double prodPrice;
	
	public Product() {
		
	}

	public int getProdId() {
		return prodId;
	}



	public void setProdId(int prodId) {
		this.prodId = prodId;
	}



	public String getProdName() {
		return prodName;
	}



	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public String getProdType() {
		return prodType;
	}



	public void setProdType(String prodType) {
		this.prodType = prodType;
	}



	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public Product(String prodName, String prodType, double prodPrice) {
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodPrice = prodPrice;
	}

	public String toString() {
		return "Product [id=" + prodId + ", product name=" + prodName + ", product type=" + prodType + ", product amount=" + prodPrice+ "]";

	}

	


}

