package com.learn.concurrency.consumer_producer.p3;

import java.util.concurrent.Semaphore;

public final class ProducerConsumerTask {
	
	private final Semaphore space;
	private final Semaphore mutex;
	private final Semaphore items;
	private final int BUFFER_SIZE;
	
	public ProducerConsumerTask(final int bufferSize) {
		this.BUFFER_SIZE = bufferSize;
		this.space = new Semaphore(this.BUFFER_SIZE);
		this.mutex = new Semaphore(1);
		this.items = new Semaphore(0);
	}
	
	public void produce(final int item) throws InterruptedException {
		
		try {
			this.space.acquire();
			this.mutex.acquire();
			System.out.println("produced :: " + item);
			SharedResource.enqueue(item);
		} finally {
			this.mutex.release();
			this.items.release();
		}
	}
	
	public void consume() throws InterruptedException {
		
		try {
			this.items.acquire();
			this.mutex.acquire();
			System.out.println("consume :: " + SharedResource.dequeue());
		} finally {
			this.mutex.release();
			this.space.release();
		}
	}
	
	public int getBUFFER_SIZE() {
		return this.BUFFER_SIZE;
	}
}
