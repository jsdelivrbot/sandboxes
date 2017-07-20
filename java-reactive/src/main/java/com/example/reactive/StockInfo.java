package com.example.reactive;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;


public class StockInfo {

	private final Stock stock;

	public StockInfo(Stock stock) {
		this.stock = stock;
	}

	public static StockInfo fetch(String stockSymbol) {
		if (Math.random() > 0.99) {
			throw new RuntimeException("StockInfo.fetch - simulated error");
		}
		try {
			return new StockInfo(YahooFinance.get(stockSymbol));
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public String toString() {
		return "StockInfo{" +
				"stock=" + stock +
				'}';
	}
}
