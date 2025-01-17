package com.learn.concurrency.consumer_producer.p1;

public class Main {
	
	public static void main(String[] args) {
		
		// producer thread
		new Thread(SharedResource::produce).start();
		// consumer thread
		new Thread(SharedResource::consume).start();
		// producer thread
		new Thread(SharedResource::produce).start();
	}
}
