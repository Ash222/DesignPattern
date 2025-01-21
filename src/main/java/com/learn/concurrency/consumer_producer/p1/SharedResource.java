package com.learn.concurrency.consumer_producer.p1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public final class SharedResource {
	
	private static final Semaphore producerSemaphore;
	private static final Semaphore consumerSemaphore;
	private static volatile int count;
	private static final Deque<Integer> queue;
	
	private SharedResource() {
	}
	
	static {
		producerSemaphore = new Semaphore(1);
		consumerSemaphore = new Semaphore(0);
		count = 0;
		queue = new LinkedList<>();
	}
	
	public static void produce() {
		
		try {
			System.out.println("producer thread waiting for the lock");
			producerSemaphore.acquire();
			System.out.println("producer thread has acquired the lock");
			for (int i = 0; i < 5; i++) {
				System.out.println("producer produced the item :: " + ++count);
				queue.offer(count);
				Thread.sleep(1000); // producer thread sleeps for 1s
			}
		} catch (InterruptedException e) {
			System.out.println("producer throws error");
		} finally {
			consumerSemaphore.release();
		}
	}
	
	public static void consume() {
		
		try {
			System.out.println("consumer thread waiting for the lock");
			consumerSemaphore.acquire();
			System.out.println("consumer thread has acquired the lock");
			for (int i = 0; i < 5; i++) {
				System.out.println("consumer consumed the item :: " + queue.poll());
				Thread.sleep(1000); // consumer thread sleeps for 1s
			}
		} catch (InterruptedException e) {
			System.out.println("consumer throws error");
		} finally {
			producerSemaphore.release();
		}
	}
}
