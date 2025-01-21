package com.learn.concurrency.consumer_producer.p1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	public static void main(String[] args) {
		
		// producer thread
		new Thread(SharedResource::produce).start();
		// consumer thread
		new Thread(SharedResource::consume).start();
		// producer thread
		new Thread(SharedResource::produce).start();
		// ExecutorService executorService = Executors.newFixedThreadPool(4);
		// executorService.submit(SharedResource::produce);
		// executorService.submit(SharedResource::consume);
		// executorService.submit(SharedResource::produce);
		// executorService.submit(SharedResource::consume);
		// executorService.shutdown();
	}
}
