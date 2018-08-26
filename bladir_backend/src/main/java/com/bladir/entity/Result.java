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

	public Result(Date date, String name, double value, User user, Standard standard) {
		super();
		this.date = date;
		this.name = name;
		this.value = value;
		this.user = user;
		this.standard = standard;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
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
	
	@Override
	public String toString() {
		return "Result [id=" + id + ", date=" + date + ", name=" + name + ", value=" + value + ", user=" + user
				+ ", standard=" + standard + "]";
	}

}
