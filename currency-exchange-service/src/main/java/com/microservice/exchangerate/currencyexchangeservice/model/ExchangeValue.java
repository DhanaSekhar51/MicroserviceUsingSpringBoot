package com.microservice.exchangerate.currencyexchangeservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exchangeservice")
public class ExchangeValue {

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="country_from")
	private String from;
	
	@Column(name="country_to")
	private String to;
	
	@Column(name="conversionamount")
	private BigDecimal conversionMultiple;
	
	@Column(name="service_port")
	private int port;

	public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple, int port) {
		super();
		this.id=id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
	}
	
	public ExchangeValue() {
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExchangeValue [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", port=" + port + "]";
	}
	
	
	
}
