package com.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oId;
    
	@Column
    private Date date;
    
    @Column
    private String phone;
    
    @Column
    private String status;
    
    @Column
    private String address;
    
    
    @Column
    private int order_amount;
    
    @ManyToOne
	@JoinColumn(name="id")
    private User user;

    public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}

}
