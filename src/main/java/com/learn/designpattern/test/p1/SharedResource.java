package com.learn.designpattern.test.p1;

public final class SharedResource {
	private static int count = 0;
	
	private SharedResource() {
	}
	
	public static int getCount() {
		return SharedResource.count;
	}
	
	public static void setCount(final int count) {
		SharedResource.count = count;
	}
}
