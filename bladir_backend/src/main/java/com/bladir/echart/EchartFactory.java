package com.bladir.echart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bladir.config.EchartConfig;
import com.bladir.database_service.UserServiceImpl;
import com.bladir.exception.InvalidDateException;

@RestController
@RequestMapping("/echart")
public class EchartFactory {
	@Autowired
	private EchartConfig config;
	
	/*@Autowired
	private UserService userService;*/
	
	@GetMapping("linechart/{username}")
	@CrossOrigin("*")
	public Dataset getLineChart(@PathVariable String username, @RequestParam("value") String value, @RequestParam("times") int times) throws InvalidDateException {
		//TODO: db related 
		//userService.queryUser();
		return getSampleLineChart(value);
	}
	
	@GetMapping("barchart/{username}")
	@CrossOrigin("*")
	public Dataset getBarChart(@PathVariable String username, @RequestParam("date") String datestring) throws InvalidDateException {
		/*try {
			userService.createUser();
			System.out.println("success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("fail");
		}*/
		Date date = parseInputDate(datestring);
		
		return getSampleBarChart();
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
		List<String> a = new ArrayList<>();
		a.add(value + " Trend");
		Legend legend = new Legend(a);
		// create x axis
		List<String> xAxis = new ArrayList<>();
		xAxis.add("2018/07/25"); xAxis.add("2018/08/25"); xAxis.add("2018/09/25");
		//main data
		List<Number> data = new ArrayList<>();
		data.add(17);  data.add(30); data.add(22);
		//MarkLineLable lable = new MarkLineLable(config.getMarkLineLableFormat());
		BoundLine upperbound = new BoundLine(25, "upper bound"/*, lable*/);
		BoundLine lowerbound = new BoundLine(15, "lower bound"/*, lable*/);
		List<BoundLine> lineset = new ArrayList<BoundLine> ();
		lineset.add(upperbound); lineset.add(lowerbound);
		MarkLineSet markLine = new MarkLineSet(lineset);
		
		DataSeriesElement element = new LineChartSeriesElement("WBC Trend", "line", data, markLine);
		List<DataSeriesElement> dataSeries = new ArrayList<>();
		dataSeries.add(element);
		
		return new Dataset(legend, xAxis, dataSeries);
	}
	
	private Dataset getSampleBarChart() {
		// create legend
		List<String> a = new ArrayList<>();
		a.add("Lower Bound"); a.add("Test Value"); a.add("Upper Bound");
		Legend legend = new Legend(a);
		// create x axis
		List<String> xAxis = new ArrayList<>();
		xAxis.add("WBC"); xAxis.add("RBC"); xAxis.add("MVC");
		// main data
		List<Number> data = new ArrayList<>();
		data.add(30);  data.add(50); data.add(15);
		DataSeriesElement mainDataSeries = new BarChartSeriesElement("Test Value", "bar", data, 0);
		
		List<Number> upperData = new ArrayList<>();
		upperData.add(40);  upperData.add(40); upperData.add(45);
		DataSeriesElement upperDataSeries = new BarChartSeriesElement("Upper Bound", "bar", upperData, 0);
		
		List<Number> lowerData = new ArrayList<>();
		lowerData.add(25);  lowerData.add(25); lowerData.add(25);
		DataSeriesElement lowerDataSeries = new BarChartSeriesElement("Lower Bound", "bar", lowerData, 0);
		
		List<DataSeriesElement> dataSeries = new ArrayList<>();
		dataSeries.add(lowerDataSeries); dataSeries.add(mainDataSeries); dataSeries.add(upperDataSeries); 
		return new Dataset(legend, xAxis, dataSeries);
	}
}
