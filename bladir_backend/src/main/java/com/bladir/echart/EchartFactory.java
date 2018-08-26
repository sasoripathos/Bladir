package com.bladir.echart;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bladir.config.EchartConfig;
import com.bladir.database_service.RecordService;
import com.bladir.database_service.StandardService;
import com.bladir.database_service.TestService;
import com.bladir.database_service.UserService;
import com.bladir.database_service.UserServiceImpl;
import com.bladir.entity.Record;
import com.bladir.entity.Standard;
import com.bladir.entity.Test;
import com.bladir.entity.User;
import com.bladir.exception.InvalidDateException;
import com.bladir.exception.ResultsNotFoundException;
import com.bladir.exception.UserNotFoundException;
import com.mysql.cj.xdevapi.Result;

@RestController
@RequestMapping("/echart")
public class EchartFactory {
	@Autowired
	private EchartConfig config;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private StandardService standardService;
	
	@GetMapping("linechart/{username}")
	@CrossOrigin("*")
	public Dataset getLineChart(@PathVariable String username, @RequestParam("value") String value, @RequestParam("times") @Min(1) int times)
			throws UserNotFoundException, ResultsNotFoundException {
		User user = userService.findUserByUsername(username);
		List<Test> tests = testService.getSortedTestByUser(user);
		Legend legend = getLineChartLegend(value);
		// create x axis value holder
		List<String> xAxis = new ArrayList<>();
		// main data
		List<Number> data = new ArrayList<>();
		// MarkLineSet
		MarkLineSet markLineSet = null;
		
		String comment = "sample comment";
		for(int i = Math.min(times,tests.size()); i>=0 ;i--) {
			Test item = tests.get(i);
			xAxis.add(dateFormater(item.getDate()));
			Record record = recordService.findRecordByTestAndStandard(item, standardService.getStandardByName(value));
			data.add(record.getValue());
			if(i==0) {
				markLineSet = getMarkLineSet(record.getStandard().getHigh(), record.getStandard().getLow());
				comment = record.getComment();
			}
		}
		DataSeriesElement element = new LineChartSeriesElement(value + " Trend", "line", data, markLineSet);
		List<DataSeriesElement> dataSeries = new ArrayList<>();
		dataSeries.add(element);
		
		return new Dataset(legend, xAxis, dataSeries, comment);
		//return getSampleLineChart(value);
	}
	
	private MarkLineSet getMarkLineSet(double high, double low) {
		BoundLine upperbound = new BoundLine(high, "upper bound");
		BoundLine lowerbound = new BoundLine(low, "lower bound");
		List<BoundLine> lineset = new ArrayList<BoundLine> ();
		lineset.add(upperbound); lineset.add(lowerbound);
		return new MarkLineSet(lineset);
	}
	
	private Legend getLineChartLegend(String value) {
		List<String> a = new ArrayList<>();
		a.add(value + " Trend");
		return new Legend(a);
	}
	
	private String dateFormater(Date date) {
		SimpleDateFormat format = new SimpleDateFormat(config.getDateFormat());
		return format.format(date);
	}
	
	@GetMapping("barchart/{username}")
	@CrossOrigin("*")
	public Dataset getBarChart(@PathVariable String username, @RequestParam("date") String datestring)
			throws InvalidDateException, UserNotFoundException, ResultsNotFoundException {
		Date date = parseInputDate(datestring);
		System.out.println(date);
		User user = userService.findUserByUsername(username);
		List<Test> allTests = user.getTests();
		System.out.println(allTests.size());
		for(Test item : allTests) {
			System.out.println("database: " + item.getDate());
			System.out.println("input: " + date);
			if(/*item.getDate().equals(date)*/compareDate(item.getDate(), date)) {
				//List<Record> records = item.getRecords();
				return createBarChartResponse(item);
			}
		}
		throw new ResultsNotFoundException("No result available!");
	}
	
	private boolean compareDate(Date dbDate, Date inputDate) {
		return (dbDate.getYear() == inputDate.getYear()
				&& dbDate.getMonth() == inputDate.getMonth()
				&& dbDate.getDay() == inputDate.getDay());
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
	
	private Legend getBarChartLegend() {
		// create legend
		List<String> a = new ArrayList<>();
		a.add("Lower Bound"); a.add("Test Value"); a.add("Upper Bound");
		return new Legend(a);
	}
	
	private Dataset createBarChartResponse(Test test) {
		List<Record> records = test.getRecords();
		// Get fixed legend
		Legend legend = getBarChartLegend();
		// create x axis value holder
		List<String> xAxis = new ArrayList<>();
		// for 3 values
		List<Number> testData = new ArrayList<>();
		List<Number> upperData = new ArrayList<>();
		List<Number> lowerData = new ArrayList<>();
		for(Record item: records) {
			Standard standard = item.getStandard();
			xAxis.add(standard.getValuename());
			upperData.add(standard.getHigh());
			lowerData.add(standard.getLow());
			testData.add(item.getValue());
		}
		// create data series
		DataSeriesElement testDataSeries = new BarChartSeriesElement("Test Value", "bar", testData, 0);
		DataSeriesElement upperDataSeries = new BarChartSeriesElement("Upper Bound", "bar", upperData, 0);
		DataSeriesElement lowerDataSeries = new BarChartSeriesElement("Lower Bound", "bar", lowerData, 0);
		
		List<DataSeriesElement> dataSeries = new ArrayList<>();
		dataSeries.add(lowerDataSeries); dataSeries.add(testDataSeries); dataSeries.add(upperDataSeries); 
		return new Dataset(legend, xAxis, dataSeries, test.getTestcoment());
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
		
		return new Dataset(legend, xAxis, dataSeries, "sample comment");
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
		return new Dataset(legend, xAxis, dataSeries, "sample comment");
	}
}
