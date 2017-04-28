package com.pubmatic.stock.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockInfo {
	
	public final static List<String> headers=new ArrayList<String>(Arrays.asList("Stock Symbol","Current Price","Year Target Price","Year High","Year Low"));
	
	private String symbol;
	
	private BigDecimal price;
	
	private BigDecimal yearLow;
	
	private BigDecimal yearHigh;
	
	private BigDecimal yearTargetPrice;

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getYearLow() {
		return yearLow;
	}

	public void setYearLow(BigDecimal yearLow) {
		this.yearLow = yearLow;
	}

	public BigDecimal getYearHigh() {
		return yearHigh;
	}

	public void setYearHigh(BigDecimal yearHigh) {
		this.yearHigh = yearHigh;
	}

	public BigDecimal getYearTargetPrice() {
		return yearTargetPrice;
	}

	public void setYearTargetPrice(BigDecimal yearTargetPrice) {
		this.yearTargetPrice = yearTargetPrice;
	}
	
	public List<String> getHeaders() {
		return headers;
	}

	public List<String> convertToList(){
		List<String> list=new ArrayList<String>();
		list.add(symbol);
		list.add(price.toPlainString());
		list.add(yearTargetPrice.toPlainString());
		list.add(yearHigh.toPlainString());
		list.add(yearLow.toPlainString());
		return list;
	}

	@Override
	public String toString() {
		return "StockInfo [symbol=" + symbol + ", price=" + price
				+ ", yearLow=" + yearLow + ", yearHigh=" + yearHigh
				+ ", yearTargetPrice=" + yearTargetPrice + "]";
	}
	
	
}
