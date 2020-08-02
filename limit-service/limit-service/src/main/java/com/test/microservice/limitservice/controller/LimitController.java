package com.test.microservice.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.microservice.limitservice.Bean.ConfigurationBean;
import com.test.microservice.limitservice.Bean.LimitserviceBean;

@RestController
public class LimitController {

	@Autowired
	private ConfigurationBean config;
	
	@GetMapping("limits")
	public LimitserviceBean getlimit() {
		System.out.println("Namaste");
		return new LimitserviceBean(config.getMinimum(),config.getMaximum());
	}
	
	@GetMapping("hyst")
	@HystrixCommand(fallbackMethod = "fallbackService")
	public LimitserviceBean hyst() {

		int a=1/0;
		System.out.println(a);
		return new LimitserviceBean(config.getMinimum(),config.getMaximum());
	}
	
	public LimitserviceBean fallbackService() {
		return new LimitserviceBean(123,1234);
	}
	
}
