package com.bladir.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="record")
public class Record {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="record_id")
	private int id;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="value_name")
	private Standard standard;
	
	@Column(name="value")
	private double value;
	
	@Column(name="record_comment")
	private String comment;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="test_id")
	private Test test;

	public Record() {
		
	}

	public Record(Standard standard, double value, String comment, Test test) {
		super();
		this.standard = standard;
		this.value = value;
		this.comment = comment;
		this.test = test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public String toString() {
		return "Record [id=" + id + ", standard=" + standard + ", value=" + value + ", comment=" + comment + ", test="
				+ test + "]";
	}


}
