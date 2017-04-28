package com.pubmatic.stockapi.connectors;

import java.util.List;

public interface IStockAPIConnectors<T> {
	public List<T> getStocksInformationBySymbols(String[] symbols) throws Exception;
}
