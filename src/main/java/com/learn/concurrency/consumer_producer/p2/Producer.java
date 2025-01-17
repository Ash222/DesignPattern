package com.learn.concurrency.consumer_producer.p2;

import java.util.concurrent.Semaphore;

public final class Producer {
	
	private final Semaphore semaphore;
	private final int producerId;
	
	public Producer(final Semaphore semaphore, final int producerId) {
		this.semaphore = semaphore;
		this.producerId = producerId;
	}
	
	public void run() {
		
		try {
			
			System.out.println("producer-" + producerId + " thread is waiting for the " +
					                   "lock :: " + SharedResources.getCount());
			while (SharedResources.getItemsProduced() < SharedResources.getMaxItems()) {
				
				if (!SharedResources.getCanConsume()) {
					semaphore.acquire();
					// System.out.println("producer-" + producerId + " thread got the lock "
					// 		                   + ":: " + SharedResources.getCount());
					
					try {
						
						if (!SharedResources.getCanConsume()) {
							SharedResources.setCount(SharedResources.getCount() + 1);
							SharedResources.setCanConsume(!SharedResources
									.getCanConsume());
							SharedResources.setItemsProduced(
									SharedResources.getItemsProduced() + 1
							);
							System.out.println("producer-" + producerId + " produced " +
									                   "item :: " + SharedResources
									.getCount());
						}
					} finally {
						// System.out.println("producer-" + producerId + " thread releases "
						// 		                   + "the lock :: " + SharedResources
						// 		.getCount());
						semaphore.release();
					}
				}
				
				// small thread delay to allow consumer thread to run
				// Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("producer-" + producerId + " throws error :: "
					                   + SharedResources.getCount());
		}
	}
}
