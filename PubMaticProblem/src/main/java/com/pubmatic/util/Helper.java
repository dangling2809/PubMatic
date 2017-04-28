package com.pubmatic.util;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.pubmatic.stock.domain.StockInfo;

import yahoofinance.Stock;

public class Helper {

	/**
	 * Converts Yahoo Stock object to StockInfo object
	 * @param stock
	 * @return
	 */
	public static StockInfo convertYahooStockToStockInfo(Stock stock){
		StockInfo stockInfo=new StockInfo();
		stockInfo.setSymbol(stock.getSymbol());
		BigDecimal yearHigh=stock.getQuote().getYearHigh()!=null?stock.getQuote().getYearHigh():new BigDecimal(-1);
		stockInfo.setYearHigh(yearHigh);
		BigDecimal yearLow=stock.getQuote().getYearLow()!=null?stock.getQuote().getYearLow():new BigDecimal(-1);
		stockInfo.setYearLow(yearLow);
		BigDecimal price=stock.getQuote().getPrice()!=null?stock.getQuote().getPrice():new BigDecimal(-1);
		stockInfo.setPrice(price);
		BigDecimal oneYearTargetPrice=stock.getStats().getOneYearTargetPrice()!=null?stock.getStats().getOneYearTargetPrice():new BigDecimal(-1);
		stockInfo.setYearTargetPrice(oneYearTargetPrice);
		return stockInfo;
	}
	
	/**
	 * Builds not found stocks object as dummy for displaying purpose
	 * @param stockSymbol
	 * @return
	 */
	public static StockInfo generateInvaildStockInfoObject(String stockSymbol){
		StockInfo invaildStockInfo=new StockInfo();
		invaildStockInfo.setSymbol(stockSymbol);
		invaildStockInfo.setYearHigh(new BigDecimal(-1));
		invaildStockInfo.setYearLow(new BigDecimal(-1));
		invaildStockInfo.setPrice(new BigDecimal(-1));
		invaildStockInfo.setYearTargetPrice(new BigDecimal(-1));
		return invaildStockInfo;
	}
}
