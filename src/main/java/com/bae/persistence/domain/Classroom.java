package com.bae.persistence.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "classrooms")
public class Classroom {

	// attributes & table annotations
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(length = 5)
	private int id;
	@Column(length = 50)
	private String trainer;
	// one to many - joining on trainee id (which represents class.id)
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "id", nullable = false, insertable = false, updatable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Trainee> trainees;

	// default constructor
	public Classroom() {
	}

	// constructor for other uses
	public Classroom(int id, String trainer, Set<Trainee> trainees) {
		super();
		this.id = id;
		this.trainer = trainer;
		this.trainees = trainees;
	}

	// getters and setters
	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
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
