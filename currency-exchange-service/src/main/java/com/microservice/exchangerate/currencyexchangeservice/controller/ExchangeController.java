package com.microservice.exchangerate.currencyexchangeservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.exchangerate.currencyexchangeservice.model.ExchangeRepository;
import com.microservice.exchangerate.currencyexchangeservice.model.ExchangeValue;

@RestController
public class ExchangeController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExchangeController.class);

	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeRepository repository;
	
	
	
	@GetMapping("currency-exchange-convertor/from/{from}/to/{to}")
	public ExchangeValue getExchangeRate(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchangeValue = new ExchangeValue();
		try {
			ExchangeValue result = repository.findByName(from,to);
			System.out.println(result.toString());  
			exchangeValue = new ExchangeValue(result.getId(),result.getFrom(), result.getTo(), result.getConversionMultiple(), Integer.parseInt(env.getProperty("server.port")));
			
		}catch(Exception e) {
			logger.info("Error while fetching records from data base.....");
		}
		
		
		
		return exchangeValue;
	}
	
}
