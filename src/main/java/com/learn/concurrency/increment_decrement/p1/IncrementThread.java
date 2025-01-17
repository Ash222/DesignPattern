package com.learn.concurrency.increment_decrement.p1;

import java.util.concurrent.Semaphore;

public class IncrementThread implements Runnable {
	
	private final Semaphore semaphore;
	private final String threadName;
	
	public IncrementThread(final Semaphore semaphore, final String threadName) {
		this.semaphore = semaphore;
		this.threadName = threadName;
	}
	
	@Override
	public void run() {
		
		try {
			
			System.out.println(threadName + " waiting for the lock :: " + SharedResource
					.getCount());
			semaphore.acquire();
			System.out.println(threadName + " lock acquired :: " + SharedResource
					.getCount());
			
			for (int i = 0; i < 5; i++) {
				SharedResource.setCount(SharedResource.getCount() + 1);
				System.out.println(threadName + " thread will sleep for 1s :: " +
						                   SharedResource.getCount());
				Thread.sleep(1000); // this thread will sleep for 1s
			}
		} catch (InterruptedException e) {
			System.out.println(
					threadName + "throws error :: " + SharedResource.getCount());
		} finally {
			System.out.println(threadName + " thread will release the lock :: " +
					                   SharedResource.getCount());
			semaphore.release();
		}
	}
}
