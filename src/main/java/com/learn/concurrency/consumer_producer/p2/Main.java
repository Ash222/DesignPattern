package com.learn.concurrency.consumer_producer.p2;

import java.util.concurrent.Semaphore;

/*
First the producer thread will produce then only any consumer thread will consume
it, otherwise it won't. After consuming again the producer thread will
produce/increment the value and the consumer thread will consume it and so on, until we
 consume/produces till the MAX_ITEMS.
  */
public class Main {
	
	public static void main(String[] args) {
		
		final Semaphore semaphore = new Semaphore(1);
		new Thread(() -> new Producer(semaphore, 1).run()).start();
		// new Thread(() -> new Producer(semaphore, 2).run()).start();
		new Thread(() -> new Consumer(semaphore, 1).run()).start();
		// new Thread(() -> new Consumer(semaphore, 2).run()).start();
		// new Thread(() -> new Consumer(semaphore, 3).run()).start();
		// new Thread(() -> new Consumer(semaphore, 4).run()).start();
	}
}
