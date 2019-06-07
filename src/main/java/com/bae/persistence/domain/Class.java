package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Class {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(length=5)
	private int id;
	@Column(length=50)
	private String trainer;
	
	public Class() {
		
	}

	public Class(int id, String trainer) {
		super();
		this.id = id;
		this.trainer = trainer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	
}
