package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainee {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length=5)
	private int traineeID;
	@Column(length=50)
	private String traineeName;
	
	public Trainee() {
		
	}
	
	public Trainee(int traineeID, String traineeName) {
		super();
		this.traineeID = traineeID;
		this.traineeName = traineeName;
	}

	public int getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(int traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
}
