package com.bladir.echart;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarkLineSet {
	@JsonProperty("data")
	private List<BoundLine> lineset;

	public MarkLineSet() {
	}
	
	public MarkLineSet(List<BoundLine> data) {
		this.lineset = data;
	}

	public List<BoundLine> getLineset() {
		return lineset;
	}

	public void setLineset(List<BoundLine> data) {
		this.lineset = data;
	}
	
	/*public void addLine(BoundLine line) {
		this.lineset.add(line);
	}*/
	
	/*public void removeLine(BoundLine line) {
		this.lineset.add(line);
	}*/
}
