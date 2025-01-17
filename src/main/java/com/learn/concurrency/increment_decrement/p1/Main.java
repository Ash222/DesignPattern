package com.learn.concurrency.increment_decrement.p1;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
		// if we give more than 1 permit then it will create the problem
		final Semaphore semaphore = new Semaphore(1);
		
		// increment thread
		new Thread(() -> new IncrementThread(semaphore, String.valueOf(1))
				.run())
				.start();
		// decrement thread
		new Thread(() -> new DecrementThread(semaphore, String.valueOf(2))
				.run())
				.start();
	}
}
