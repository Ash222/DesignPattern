package com.learn.designpattern.test.p1;

// import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	
	public static void main(String[] args) {
/* 		final Semaphore semaphore = new Semaphore(1);
		new IncThread(semaphore,"A-Thread");
		new DecThread(semaphore,"B-Thread"); */
		final ReentrantLock reentrantLock = new ReentrantLock();
		new IncThread(reentrantLock,"A-Thread");
		new DecThread(reentrantLock,"B-Thread");
	}
}
