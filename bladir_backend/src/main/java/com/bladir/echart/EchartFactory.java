package com.bladir.echart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bladir.config.EchartConfig;
import com.bladir.exception.InvalidDateException;

@RestController
@RequestMapping("/echart")
public class EchartFactory {
	@Autowired
	private EchartConfig config;
	
	@GetMapping("linechart/{id}")
	public Dataset getLineChart(@PathVariable int id, @RequestParam("value") String value) throws InvalidDateException {
		//TODO: db related 
		
		return getSampleLineChart(value);
	}
	private Date parseInputDate(String dateinput) throws InvalidDateException {
		SimpleDateFormat format = new SimpleDateFormat(config.getDateFormat());
		try {
			return format.parse(dateinput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw(new InvalidDateException("Invalid Date", e));
		}
	}
	private Dataset getSampleLineChart(String value) throws InvalidDateException {
		//Date date = parseInputDate(dateText);
		// create legend
		List<String> a = new ArrayList();
		a.add(value + " Trend");
		Legend legend = new Legend(a);
		// create x axis
		List<String> xAxis = new ArrayList();
		xAxis.add("2018/07/25"); xAxis.add("2018/08/25"); xAxis.add("2018/09/25");
		List<Number> data = new ArrayList();
		data.add(17);  data.add(30); data.add(22);
		//MarkLineLable lable = new MarkLineLable(config.getMarkLineLableFormat());
		BoundLine upperbound = new BoundLine(25, "upper bound"/*, lable*/);
		BoundLine lowerbound = new BoundLine(15, "lower bound"/*, lable*/);
		List<BoundLine> lineset = new ArrayList<BoundLine> ();
		lineset.add(upperbound); lineset.add(lowerbound);
;		MarkLineSet markLine = new MarkLineSet(lineset);
		
		DataSeriesElement element = new LineChartSeriesElement("WBC Trend", "line", data, markLine);
		List<DataSeriesElement> dataSeries = new ArrayList<>();
		dataSeries.add(element);
		
		return new Dataset(legend, xAxis, dataSeries);
	}
}
