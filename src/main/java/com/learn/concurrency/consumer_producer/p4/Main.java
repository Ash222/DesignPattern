package com.learn.concurrency.consumer_producer.p4;

public class Main {
	
	public static void main(String[] args) {
		
		// producer thread
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				ProducerConsumerResource.produce(i);
				sleep(1000); // slight delay to let the other thread run
			}
		}).start();
		
		// consumer thread
		new Thread(() -> {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Consumer :: " + ProducerConsumerResource.consume());
				sleep(1000); // slight delay to let the other thread run
			}
		}).start();
	}
	
	private static void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Error while sleeping");
		}
	}
}
