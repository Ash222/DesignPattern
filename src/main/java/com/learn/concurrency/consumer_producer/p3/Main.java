package com.learn.concurrency.consumer_producer.p3;

public class Main {
	
	public static void main(String[] args) {
		
		final ProducerConsumerTask pcTask = new ProducerConsumerTask(5);
		// producer thread
		final Thread p = new Thread(() -> {
			try {
				for (int i = 0; i < 9; i++) {
					pcTask.produce(i);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("p error");
			}
		});
		// consumer thread
		final Thread c = new Thread(() -> {
			try {
				for (int i = 0; i < 9; i++) {
					pcTask.consume();
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("p error");
			}
		});
		p.start();
		c.start();
	}
}
