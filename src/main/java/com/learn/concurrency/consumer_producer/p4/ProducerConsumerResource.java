package com.learn.concurrency.consumer_producer.p4;

import java.util.concurrent.Semaphore;

public final class ProducerConsumerResource {
	
	private static final Semaphore producerSemaphore;
	private static final Semaphore consumerSemaphore;
	private static volatile int count;
	
	private ProducerConsumerResource() {
	}
	
	static {
		producerSemaphore = new Semaphore(1);
		consumerSemaphore = new Semaphore(0);
		count = 0;
	}
	
	public static void produce(final int item) {
		try {
			producerSemaphore.acquire();
			System.out.println("produced :: " + (count = item));
		} catch (InterruptedException e) {
			System.out.println("Error while producing!");
			producerSemaphore.release();
		} finally {
			consumerSemaphore.release();
		}
	}
	
	public static int consume() {
		try {
			consumerSemaphore.acquire();
			System.out.println("consumed :: " + count);
			return count;
		} catch (InterruptedException e) {
			System.out.println("Error while consuming!");
			consumerSemaphore.release();
		} finally {
			producerSemaphore.release();
		}
		return -1; // error
	}
}
