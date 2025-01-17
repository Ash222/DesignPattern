package com.learn.concurrency.consumer_producer.p3;

import java.util.Deque;
import java.util.LinkedList;

public final class SharedResource {
	
	private static final Deque<Integer> queue;
	
	private SharedResource() {
	}
	
	static {
		queue = new LinkedList<>();
	}
	
	public static void enqueue(final int number) {
		queue.offer(number);
	}
	
	public static int dequeue() {
		if (queue.isEmpty()) {
			return -1;
		}
		return queue.poll();
	}
}
