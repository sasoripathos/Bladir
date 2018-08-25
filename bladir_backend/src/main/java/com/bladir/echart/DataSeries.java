package com.bladir.echart;

import java.util.List;

public abstract class DataSeries {
	private String name;
	private String type;
	private List<Number> data;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Number> getData() {
		return data;
	}
	public void setData(List<Number> data) {
		this.data = data;
	}
	
	
}
