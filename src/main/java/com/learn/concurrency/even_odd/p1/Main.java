package com.learn.concurrency.even_odd.p1;

import java.util.concurrent.Semaphore;

public class Main {
	
	private static final Semaphore evenSemaphore;
	private static final Semaphore oddSemaphore;
	private static volatile int number;
	
	static {
		evenSemaphore = new Semaphore(1);
		oddSemaphore = new Semaphore(0);
		number = 0;
	}
	
	public static void main(String[] args) {
		
		// even thread
		new Thread(() -> {
			while (true) {
				try {
					evenSemaphore.acquire();
					if (number > 10) {
						oddSemaphore.release();
						break;
					}
					if (number % 2 == 0) {
						System.out.println("even number :: " + number);
					}
					increment();
					// sleep(1000); // slight delay to let the other thread run
				} catch (InterruptedException e) {
					evenSemaphore.release();
				} finally {
					oddSemaphore.release();
				}
			}
		}).start();
		// odd thread
		new Thread(() -> {
			while (true) {
				try {
					oddSemaphore.acquire();
					if (number > 10) {
						evenSemaphore.release();
						break;
					}
					if (number % 2 != 0) {
						System.out.println("odd number :: " + number);
					}
					increment();
					// sleep(1000); // slight delay to let the other thread run
				} catch (InterruptedException e) {
					oddSemaphore.release();
				} finally {
					evenSemaphore.release();
				}
			}
		}).start();
	}
	
	private static void increment() {
		number++;
	}
	
	private static void sleep(final long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			System.out.println("Error while sleeping");
		}
	}
}
