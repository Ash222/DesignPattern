package com.learn.concurrency.consumer_producer.p2;

import java.util.concurrent.Semaphore;

public final class Consumer {
	
	private final Semaphore semaphore;
	private final int consumerId;
	
	public Consumer(final Semaphore semaphore, final int consumerId) {
		this.semaphore = semaphore;
		this.consumerId = consumerId;
	}
	
	public void run() {
		
		try {
			
			System.out.println("consumer-" + consumerId + " thread is waiting for the " +
					                   "lock :: " + SharedResources.getCount());
			
			while (SharedResources.getItemsConsumed() < SharedResources.getMaxItems()) {
				
				if (SharedResources.getCanConsume()) {
					semaphore.acquire();
					// System.out.println("consumer-" + consumerId + " thread got the " +
					// 		                   "lock :: " + SharedResources.getCount());
					
					try {
						if (SharedResources.getCanConsume()) {
							SharedResources.setCanConsume(!SharedResources
									.getCanConsume());
							SharedResources.setItemsConsumed(
									SharedResources.getItemsConsumed() + 1
							);
							System.out.println("consumer-" + consumerId + " consumed " +
									                   "item :: " + SharedResources
									.getCount());
						}
					} finally {
						// System.out.println("consumer-" + consumerId + " thread releases "
						// 		                   + "the lock :: " + SharedResources
						// 		.getCount());
						semaphore.release();
					}
				}
				
				// small delay in thread to allow producer thread to run
				// Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("consumer-" + consumerId + " thread is waiting for the " +
					                   "lock :: " + SharedResources.getCount());
		}
	}
}
