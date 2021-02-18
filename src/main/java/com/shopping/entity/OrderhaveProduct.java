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
@Table(name = "tb_orderhaveproduct")
public class OrderhaveProduct {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long ohdId;
	 
	 @ManyToOne
	 @JoinColumn(name="oId")
	 private Order order;
	 
	 @ManyToOne
	 @JoinColumn(name="pId")
	 private Product product;
	 
}
