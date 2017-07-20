package com.example.reactive;


import io.reactivex.Observable;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class StockService {

	static Observable<StockInfo> getStockFeeds(List<String> stockSymbols) throws IOException {
		//Creates an observable, the parameter is an "ObservableOnSubscribe" functional interface which
		return Observable.create(
			//subscriber = ObservableEmitter<StockInfo>
			subscriber -> {
				try {
					while (!subscriber.isDisposed()) {
						stockSymbols.stream()
								//Transform each stock symbol to a StockInfo
								.map(StockInfo::fetch)
								//Emit the StockInfo which will be pushed to the subscriber (via its onNext method)
								.forEach(subscriber::onNext);
						sleep(1000);
					}
				} catch (Exception ex) {
					//Signal to an observer that an error has occurred.
					// This will send a message to the observer's error channel (Consumer).
					subscriber.onError(ex);
				}

				//Signals to the subscriber that the observable is done with its work.  If the client passed in an onComplete
				//Action to the subscribe method, the Action would be invoked at this time.
				subscriber.onComplete();
			});
	}
}
