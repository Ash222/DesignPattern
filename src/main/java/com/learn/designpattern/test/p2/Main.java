package com.learn.designpattern.test.p2;

// import java.util.concurrent.locks.ReentrantLock;

import java.util.concurrent.Semaphore;

public class Main {
	
	public static void main(String[] args) {
		
/* 		final ReentrantLock reentrantLock = new ReentrantLock();
		new EvenThread(reentrantLock);
		new OddThread(reentrantLock); */
		final Semaphore semaphore = new Semaphore(1);
		new EvenThread(semaphore);
		new OddThread(semaphore);
	}
}
