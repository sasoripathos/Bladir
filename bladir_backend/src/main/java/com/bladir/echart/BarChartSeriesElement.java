package com.bladir.echart;

import java.util.List;

public class BarChartSeriesElement extends DataSeriesElement {
	private double barGap;
	
	public BarChartSeriesElement() {
		
	}

	public BarChartSeriesElement(String name, String type, List<Number> data, double barGap) {
		this.barGap = barGap;
		this.setData(data);
		this.setName(name);
		this.setType(type);
	}

	public double getBarGap() {
		return barGap;
	}

	public void setBarGap(double barGap) {
		this.barGap = barGap;
	}
	
	
}
