package com.bae.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trainees")
public class Trainee {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int traineeID;
	@Column(length = 50)
	private String traineeName;
	@Column(length = 50)
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Classroom classroom;

	// default constructor
	public Trainee() {
	}

	// constructor for other uses
	public Trainee(int traineeID, String traineeName, String id) {
		super();
		this.traineeID = traineeID;
		this.traineeName = traineeName;
		this.id = id;
	}

	// getters and setters
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

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}
}
