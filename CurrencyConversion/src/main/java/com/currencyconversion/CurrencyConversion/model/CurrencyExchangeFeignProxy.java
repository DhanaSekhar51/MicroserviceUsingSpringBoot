package com.currencyconversion.CurrencyConversion.model;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-convertor",url = "http://localhost:8000")
@FeignClient(name="zuul-api-gateway")
@RibbonClient(name = "currency-exchange-convertor")
public interface CurrencyExchangeFeignProxy {

	@GetMapping("/currency-exchange-convertor/currency-exchange-convertor/from/{from}/to/{to}")
	CurrencyValue getExchangeDetails(@PathVariable String from, @PathVariable String to);
	
}
