package com.learn.designpattern.test.p1;

// import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class DecThread implements Runnable {
	
	private final String decrementThreadName;
	private final ReentrantLock reentrantLock;
	// private final Semaphore semaphore;
	
	/* public DecThread(final Semaphore semaphore, final String decrementThreadName) {
		this.decrementThreadName = decrementThreadName;
		this.semaphore = semaphore;
		new Thread(this).start();
	} */
	
	public DecThread(final ReentrantLock reentrantLock,
			final String decrementThreadName) {
		this.decrementThreadName = decrementThreadName;
		this.reentrantLock = reentrantLock;
		new Thread(this).start();
	}
	
	@Override
	public void run() {
		
		System.out.println(decrementThreadName + " is waiting for the lock");
		try {
			// acquire the lock
			// semaphore.acquire();
			reentrantLock.lock();
			System.out.println(decrementThreadName + " gets the lock :: " + SharedResource
					.getCount());
			for (int i = 0; i < 5; i++) {
				SharedResource.setCount(SharedResource.getCount() - 1);
				System.out.println(decrementThreadName + " :: count :: " + SharedResource
						.getCount());
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(decrementThreadName + " throws the error");
		} finally {
			// release the lock
			// semaphore.release();
			reentrantLock.unlock();
		}
	}
}
