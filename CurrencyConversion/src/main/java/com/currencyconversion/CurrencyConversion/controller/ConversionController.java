package com.currencyconversion.CurrencyConversion.controller;

import java.math.BigDecimal;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.currencyconversion.CurrencyConversion.model.CurrencyExchangeFeignProxy;
import com.currencyconversion.CurrencyConversion.model.CurrencyValue;
import com.currencyconversion.CurrencyConversion.model.Sample;

@RestController
public class ConversionController {
	private static final Logger logger = LoggerFactory.getLogger(ConversionController.class);
	
	@Autowired
	CurrencyExchangeFeignProxy proxy;
	
	@GetMapping("currencyconverter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyValue getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
		
//		Map<String, String> map = new HashMap<String,String>();
//		map.put("from",from);
//		map.put("to", to);
//		
//		ResponseEntity<CurrencyValue> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange-convertor/from/{from}/to/{to}", CurrencyValue.class,map);
//		
//		CurrencyValue result = response.getBody();
		
		HttpHeaders header = new HttpHeaders();
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<CurrencyValue> entity = new HttpEntity<>(header);
		
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<CurrencyValue> exchange = restTemplate.exchange("http://localhost:8000/currency-exchange-convertor/from/"+from+"/to/"+to, HttpMethod.GET, entity, CurrencyValue.class);
		
		CurrencyValue body = exchange.getBody();
		logger.info("result -----------> "+body);
		
		
		
		
		return body;
	}
	
	@GetMapping("currencyconverterfeign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyValue getCurrencyconversionfeign(@PathVariable String from, @PathVariable String to) {
		
		logger.info("Hello.....");
		
		CurrencyValue details = proxy.getExchangeDetails(from, to);
		
		logger.info("details ------> "+details);
		
		
		return details;
	}

//	@PostMapping(value="currencyConversion",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String postMa(@RequestBody Sample req) {
//		logger.info("hi "+req.getName());
//		
//		return req.getName();
//		
//	}
	

}
