package com.dm.official.dto;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dm.official.filter.MyFilter;

@Configuration
public class WebConfig {
	@Bean
	public FilterRegistrationBean filterRegistrationBean(MyFilter myFilter) {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(myFilter);
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.addUrlPatterns("/i/*");
		return filterRegistrationBean;
	}
}