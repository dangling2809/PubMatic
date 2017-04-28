package com.pubmatic.report;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static java.util.logging.Level.*;

import java.util.logging.Logger;

import com.pubmatic.stock.domain.StockInfo;

public class CSVReportGeneratorImpl implements IReportGenerator{

	private static Logger logger=Logger.getLogger(CSVReportGeneratorImpl.class.getName());
	
	private List<StockInfo> stockInfos;
	
	private String csvFileName;
	
	public CSVReportGeneratorImpl(List<StockInfo> stockInfos, String csvFileName) {
		super();
		this.stockInfos = stockInfos;
		this.csvFileName = csvFileName;
	}

	public void generateReport() {
		logger.log(INFO,"Writing report to -->"+csvFileName);
        try(FileWriter writer = new FileWriter(csvFileName);){
        	CSVWriter.writeLine(writer, StockInfo.headers);
        	logger.log(INFO,"Generated Headers "+StockInfo.headers);
        	for(StockInfo info:stockInfos){
        		logger.log(INFO,"Writing record to CSV-->"+info);
        		CSVWriter.writeLine(writer, info.convertToList());
        	}
        	writer.flush();
        	logger.log(INFO,"Report Generated Successfully ");
        } catch (IOException e) {
        	logger.log(SEVERE,"Error in generating csv report",e);
			throw new RuntimeException("Exception while writing to csv file",e);
		}
	}
	
}
