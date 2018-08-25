package com.bladir.echart;

import java.util.List;

public class Dataset {
	private Legend legend;
	private List<String> xAxisData;
	
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
	
}
