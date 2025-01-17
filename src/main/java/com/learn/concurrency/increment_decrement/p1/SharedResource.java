package com.learn.concurrency.increment_decrement.p1;

public final class SharedResource {
	
	// since we want to get this value from main memory rather than
	// local
	private static volatile int count = 0;
	
	private SharedResource(){
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void setCount(final int count) {
		SharedResource.count = count;
	}
}
