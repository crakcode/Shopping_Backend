package com.shopping.entity;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "tb_order_have_product")
public class OrderhaveProduct {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long ohpId;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="oId")
	 private Order order;
	 
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="pId")
	 private Product product;

	 @Column
	 private String status;
	 
	public Long getOhpId() {
		return ohpId;
	}

	public void setOhpId(Long ohpId) {
		this.ohpId = ohpId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	 
}
