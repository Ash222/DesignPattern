package com.learn.designpattern.test.p2;

// import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Semaphore;

public final class EvenThread implements Runnable {
	
	// private final ReentrantLock reentrantLock;
	private final Semaphore semaphore;
	private final String threadName;
	
/* 	public EvenThread(final ReentrantLock reentrantLock) {
		this.reentrantLock = reentrantLock;
		this.threadName = "E-thread";
		new Thread(this).start();
	} */
	
	public EvenThread(final Semaphore semaphore) {
		this.semaphore = semaphore;
		this.threadName = "E-thread";
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		while (SharedResource.getCount() < 11) {
			System.out.println(threadName + " is waiting to get the lock :: "
					                   + SharedResource.getCount());
			// check if the count value is even
			if (SharedResource.getCount() % 2 == 0) {
				try {
					// acquire lock
					// reentrantLock.lock();
					semaphore.acquire();
					System.out.println(threadName + " gets the lock :: " + SharedResource
							.getCount());
					
					// now check to make sure the count value is changed
					if (SharedResource.getCount() % 2 == 0) {
						System.out.println(threadName + " :: count :: " + SharedResource
								.getCount());
						SharedResource.setCount(SharedResource.getCount() + 1);
					}
				} catch (InterruptedException e) {
					System.out.println(threadName + " throws error :: " + SharedResource
							.getCount());
				} finally {
					// release the lock
					// reentrantLock.unlock();
					semaphore.release();
				}
			}
		}
	}
}
