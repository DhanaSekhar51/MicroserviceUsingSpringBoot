package com.test.microservice.limitservice.Bean;

public class LimitserviceBean {
	
	private int minimum;
	private int maximum;
	
	public LimitserviceBean() {
		
	}
	
	public LimitserviceBean(int minimum, int maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	
	
	

}
