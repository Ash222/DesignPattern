package com.learn.designpattern.test.p1;

// import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class IncThread implements Runnable {
	
	private final String incrementThreadName;
	private final ReentrantLock reentrantLock;
	// private final Semaphore semaphore;
	
/* 	public IncThread(final Semaphore semaphore, final String incrementThreadName) {
		this.incrementThreadName = incrementThreadName;
		this.semaphore = semaphore;
		new Thread(this).start();
	} */
	
	public IncThread(final ReentrantLock reentrantLock,
			final String incrementThreadName) {
		this.incrementThreadName = incrementThreadName;
		this.reentrantLock = reentrantLock;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		System.out.println(incrementThreadName + " is waiting for the lock");
		try {
			// acquire the lock
			// semaphore.acquire();
			reentrantLock.lock();
			System.out.println(incrementThreadName + " gets the lock :: " + SharedResource
					.getCount());
			
			for (int i = 0; i < 5; i++) {
				SharedResource.setCount(SharedResource.getCount() + 1);
				System.out.println(incrementThreadName + " :: count :: " + SharedResource
						.getCount());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(incrementThreadName + " throws error");
		} finally {
			// release the lock
			// semaphore.release();
			reentrantLock.unlock();
		}
	}
}
