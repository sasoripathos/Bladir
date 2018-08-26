package com.bladir.echart;

import java.util.List;

public class Dataset {
	private Legend legend;
	private List<String> xAxisData;
	private List<DataSeriesElement> series;
	private String comment;
	
	public Dataset() {
		
	}
	
	public Dataset(Legend legend, List<String> xAxisData, List<DataSeriesElement> series, String comment) {
		this.legend = legend;
		this.xAxisData = xAxisData;
		this.series = series;
		this.comment = comment;
	}
	
	public List<DataSeriesElement> getSeries() {
		return series;
	}
	public void setSeries(List<DataSeriesElement> series) {
		this.series = series;
	}
	public Legend getLegend() {
		return legend;
	}
	public void setLegend(Legend legend) {
		this.legend = legend;
	}
	public List<String> getxAxisData() {
		return xAxisData;
	}
	public void setxAxisData(List<String> xAxisData) {
		this.xAxisData = xAxisData;
	}
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
