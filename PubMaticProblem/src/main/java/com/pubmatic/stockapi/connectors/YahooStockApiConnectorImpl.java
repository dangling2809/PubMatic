package com.pubmatic.stockapi.connectors;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pubmatic.report.CSVReportGeneratorImpl;
import com.pubmatic.stock.domain.StockInfo;
import com.pubmatic.util.Helper;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class YahooStockApiConnectorImpl implements IStockAPIConnectors<StockInfo>{

	private static Logger logger=Logger.getLogger(CSVReportGeneratorImpl.class.getName());
	
	public static ConcurrentHashMap<String, Stock> stocks=new ConcurrentHashMap<String, Stock>();
	
	public List<StockInfo> getStocksInformationBySymbols(String[] symbols) throws IOException{
		getStocksInformation(symbols);
		List<StockInfo> list=new ArrayList<StockInfo>();
		for(String symbol:symbols){
			Stock stock=stocks.get(symbol);
			if(stock!=null){
				list.add(Helper.convertYahooStockToStockInfo(stock));
			}else{
				list.add(Helper.generateInvaildStockInfoObject(symbol));
			}
		}
		return list;
	}

	private void getStocksInformation(String[] symbols) throws IOException {
		logger.log(Level.INFO,"Connecting to Yahoo API");
		logger.log(Level.INFO,"Fetching records");
		stocks.putAll(YahooFinance.get(symbols));//store them for purpose of future caching not implementing now;
		logger.log(Level.INFO,"Fetched data for following symbols"+Arrays.toString(symbols));
	}


	
}
