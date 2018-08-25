package com.bladir.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="result")
public class Result {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="record_id")
	private int id;

	@Column(name="date")
	private Date date;
	
	@Column(name="name")
	private String name;
	
	@Column(name="test_name")
	private String value_name;
	
	@Column(name="value")
	private double value;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="patient_id")
	private User user;


	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="test_name")
	private Standard standard;

	public Result() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue_name() {
		return value_name;
	}

	public void setValue_name(String value_name) {
		this.value_name = value_name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Result(int patientId, Date date, String name, String value_name, Double value) {
		this.date = date;
		this.name = name;
		this.value_name = value_name;
		this.value = value;
	}
}
