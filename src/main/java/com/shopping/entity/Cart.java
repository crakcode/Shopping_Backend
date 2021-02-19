package com.shopping.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_cart")
public class Cart {
	 public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	 public Long getOhdId() {
		return ohdId;
	}

	public void setOhdId(Long ohdId) {
		this.ohdId = ohdId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long ohdId;
	 
	 
	 @Column
	 private String status;

	 @Column
	 private int amount;
	 
	 @ManyToOne
	 @JoinColumn(name="pId")
	 private Product product;
	 
	 
	 @ManyToOne
	 @JoinColumn(name="oId")
	 private Order order;

	 
}
