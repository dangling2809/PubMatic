package com.pubmatic;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.pubmatic.report.CSVReportGeneratorImpl;
import com.pubmatic.report.IReportGenerator;
import com.pubmatic.stock.domain.StockInfo;
import com.pubmatic.stockapi.connectors.IStockAPIConnectors;
import com.pubmatic.stockapi.connectors.YahooStockApiConnectorImpl;
import com.pubmatic.util.InputParser;

public class App {

	private static Logger logger=Logger.getLogger(App.class.getName());
	
	public static void main(String[] args) {
		if(args!=null && args.length>0){
			long startTime = System.nanoTime();
			String[] symbols=null;
			//parse input text file
			InputParser parser=new InputParser();
			try {
				logger.log(Level.INFO, "Parsing Input File");
				symbols=parser.parse(args[0]);
				logger.log(Level.INFO, "Parsed Input File succsfully");
				logger.log(Level.INFO,"List of stocks ->"+Arrays.toString(symbols));
			} catch (IOException e) {
				logger.log(Level.SEVERE,"File not found at path-->"+args[0]+e.getMessage());
				//Can use custom exceptions
				throw new RuntimeException("File not found at path-->"+args[0],e);
			}
			//connect to 
			IStockAPIConnectors<StockInfo> apiConnector=new YahooStockApiConnectorImpl();
			try {
				List<StockInfo> stockInfos=apiConnector.getStocksInformationBySymbols(symbols);
				IReportGenerator reportGenerator=new CSVReportGeneratorImpl(stockInfos, "Output.csv");
				reportGenerator.generateReport();
			} catch (Exception e) {
				logger.log(Level.SEVERE,e.getMessage());
				//Can use custom exceptions
				throw new RuntimeException("Not able to connect to to Yahoo finance api ,"+ "Kindly check you internet connection",e);
			}
			long endTime = System.nanoTime();
			long duration = (endTime - startTime)/1000000;
			System.out.println("Time spent "+TimeUnit.MILLISECONDS.toSeconds(duration) + " Seconds");
		}else{
			logger.log(Level.SEVERE,"Please provide stock symbol list file");
		}
	}
}
