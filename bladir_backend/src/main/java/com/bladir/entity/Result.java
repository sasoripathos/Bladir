package com.bladir.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="result")
public class Result {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="record_id")
	private int id;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="name")
	private String name;
	
	@Column(name="test_name")
	private String value_name;
	
	@Column(name="value")
	private double value;

	public Result() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public Result(int patientId, Date date, String name, String value_name, Double value) {
		this.patientId = patientId;
		this.date = date;
		this.name = name;
		this.value_name = value_name;
		this.value = value;
	}
}
