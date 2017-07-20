package com.example.reactive;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Application {

	public static void main(String[] args) throws IOException {
		YahooFinance.logger.setLevel(Level.SEVERE);

		List<String> symbols = Arrays.asList("TSLA", "YHOO", "NFLX");
		Observable<StockInfo> feed = StockService.getStockFeeds(symbols);

		//Asynchronous subscription
		feed.subscribeOn(Schedulers.io())
				.subscribe(new Observer<StockInfo>() {

					Disposable disposable;
					int callCount = 0;

					@Override
					public void onSubscribe(Disposable d) {
						disposable = d;
						System.out.println("ASYNC subscriber: onSubscribe called with Disposable " + d.toString());
					}

					@Override
					public void onNext(StockInfo stockInfo) {
						System.out.println("ASYNC subscriber: onNext called with StockInfo: " + stockInfo.toString());
						callCount++;

						//Unsubscribe after receiving 10 events
						if (callCount > 10) {
							disposable.dispose();
						}
					}

					@Override
					public void onError(Throwable e) {
						System.out.println("ASYNC subscriber: onError called:  " + e);
					}

					@Override
					public void onComplete() {
						System.out.println("ASYNC subscriber: onComplete called");
					}
				});

		//Synchronous subscription - execution does not move past this line until observable completion (or an error)
		feed.subscribe(
				(stockInfo) -> {
					System.out.println("SYNC subscriber: onNext called with StockInfo: " + stockInfo);
				},
				(error) -> System.out.println("SYNC subscriber: onError called: " + error),
				() -> System.out.println("SYNC subscriber: onComplete Action invoked."),
				(upstreamDisposable) -> System.out.println("SYNC subscriber: disposable added: " + upstreamDisposable.toString()));
	}
}
