package com.bladir.echart;

public class BoundLine {
	private Number yAxis;
	private String name;
	//private MarkLineLable label;
	
	public BoundLine() {
		
	}
	
	public BoundLine(Number yAxis, String name/*, MarkLineLable label*/) {
		this.yAxis = yAxis;
		this.name = name;
		//this.label = label;
	}

	public Number getyAxis() {
		return yAxis;
	}
	public void setyAxis(Number yAxis) {
		this.yAxis = yAxis;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/*public MarkLineLable getLabel() {
		return label;
	}

	public void setLabel(MarkLineLable label) {
		this.label = label;
	}*/
}
