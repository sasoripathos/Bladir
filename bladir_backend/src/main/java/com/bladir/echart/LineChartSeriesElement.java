package com.bladir.echart;

import java.util.List;

public class LineChartSeriesElement extends DataSeriesElement {

	private MarkLineSet markLine;

	/*public LineChartSeries(MarkLineSet markLine) {
		super();
		this.markLine = markLine;
	}*/
	public LineChartSeriesElement() {
	}
	
	public LineChartSeriesElement(String name, String type, List<Number> data, MarkLineSet markLine) {
		this.markLine = markLine;
		this.setData(data);
		this.setName(name);
		this.setType(type);
	}
	
	public MarkLineSet getMarkLine() {
		return markLine;
	}

	public void setMarkLine(MarkLineSet markLine) {
		this.markLine = markLine;
	}

}
