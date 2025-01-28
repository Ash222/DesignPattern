package com.learn.concurrency.bucket_of_tokens.p1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Imagine you have a bucket that gets filled with tokens at the rate of 1 token per
second. The bucket can hold a maximum of N tokens. Implement a thread-safe class that
lets threads get a token when one is available. If no token is available, then the
token-requesting threads should block. The class should expose an API called getToken
that various threads can call to get a token.
*/
public class Main {
	
	public static void main(String[] args) {
		
		BucketToken bucket = new BucketToken(5); // Bucket with max 5 tokens
		
		Runnable task = () -> {
			bucket.getToken();
			System.out.println(Thread.currentThread().getName() + " acquired a token.");
		};
		
		// Simulate multiple threads requesting tokens
		for (int i = 0; i < 10; i++) {
			new Thread(task).start();
		}
	}
	
	private static final class BucketToken {
		
		private final int maxToken;
		private volatile int currentToken;
		private final Lock lock;
		private final Condition tokenAvailable;
		
		public BucketToken(final int maxToken) {
			this.maxToken = maxToken;
			this.currentToken = 0;
			this.lock = new ReentrantLock();
			this.tokenAvailable = lock.newCondition();
			fillTheTokens();
		}
		
		public void getToken() {
			try {
				lock.lock();
				// Since it is given that, if no token is available, then the
				// token-requesting threads should block/wait.
				while (currentToken == 0) {
					// releases the lock and goes into waiting state and reacquire the
					// lock once it gets out of the waiting state.
					tokenAvailable.await();
				}
				currentToken--;
				System.out.println(Thread.currentThread().getName() + " :: currentToken "
						                   + ":: getToken :: " + currentToken);
			} catch (Exception e) {
				System.out.println("error");
			} finally {
				lock.unlock();
			}
		}
		
		// Since it is given that token will increase at 1token/sec. Hence, used
		// scheduler which runs after every 1sec.
		private void fillTheTokens() {
			final ScheduledExecutorService scheduledExecutorService = Executors
					.newScheduledThreadPool(1);
			scheduledExecutorService.scheduleAtFixedRate(() -> {
				try {
					lock.lock();
					if (currentToken < maxToken) {
						currentToken++;
						System.out.println(Thread.currentThread().getName() +
								                   " :: currentToken :: " + currentToken);
						tokenAvailable.signalAll();
					}
				} catch (Exception e) {
					System.out.println("error while filling the tokens");
				} finally {
					lock.unlock();
				}
			}, 1, 1, TimeUnit.SECONDS);
		}
	}
}
