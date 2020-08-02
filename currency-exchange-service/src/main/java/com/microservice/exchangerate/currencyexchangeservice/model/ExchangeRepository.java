package com.microservice.exchangerate.currencyexchangeservice.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ExchangeRepository extends JpaRepository<ExchangeValue, Long>{

	@Query(value="select * from exchangeservice e where e.country_from=?1 and e.country_to=?2", nativeQuery = true)
	ExchangeValue findByName(String from,String to);

	
}
