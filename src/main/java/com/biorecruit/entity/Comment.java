package com.biorecruit.entity;

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
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
	
	 @Id 
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name = "c_id")
	 private Long cId;
	 
	 @Column
	 private String description;
	 
	 @ManyToOne
	 @JoinColumn(name = "id")
	 private User user;	
	 
	 @ManyToOne
	 @JoinColumn(name = "p_id")
	 private Post post;	

	 
}
