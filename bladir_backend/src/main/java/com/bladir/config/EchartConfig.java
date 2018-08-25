package com.bladir.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ConfigurationProperties("echart")
public class EchartConfig {
	
	private String dateFormat;
	private String markLineLableFormat;

	public String getMarkLineLableFormat() {
		return markLineLableFormat;
	}

	public void setMarkLineLableFormat(String markLineLableFormat) {
		this.markLineLableFormat = markLineLableFormat;
	}
	
	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
