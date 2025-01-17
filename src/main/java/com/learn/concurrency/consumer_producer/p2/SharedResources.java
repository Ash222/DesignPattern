package com.learn.concurrency.consumer_producer.p2;


public final class SharedResources {
	
	// this is the resource that both producer and consumer thread will access
	private static volatile int count;
	// this variable will keep track if the consumer thread can access count
	// if it acquires the lock first. Both thread will flip it alternatively. This is
	// like a switch to inform the threads to switch.
	private static volatile boolean canConsume;
	// max items that producer can produce and consumer can consume.
	private static final int MAX_ITEMS = 5;
	// producer threads will use this variable to keep track of the item produced. It
	// should not exceed the MAX_ITEMS.
	private static volatile int itemsProduced;
	// consumer thread will use this variable to keep track of the items consumed. It
	// should not exceed the MAX_ITEMS.
	private static volatile int itemsConsumed;
	
	private SharedResources() {
	}
	
	static {
		count = 0;
		canConsume = false;
		itemsProduced = 0;
		itemsConsumed = 0;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void setCount(final int count) {
		SharedResources.count = count;
	}
	
	public static boolean getCanConsume() {
		return canConsume;
	}
	
	public static void setCanConsume(final boolean canConsume) {
		SharedResources.canConsume = canConsume;
	}
	
	public static int getItemsProduced() {
		return itemsProduced;
	}
	
	public static void setItemsProduced(final int itemsProduced) {
		SharedResources.itemsProduced = itemsProduced;
	}
	
	public static int getItemsConsumed() {
		return itemsConsumed;
	}
	
	public static void setItemsConsumed(final int itemsConsumed) {
		SharedResources.itemsConsumed = itemsConsumed;
	}
	
	public static int getMaxItems(){
		return MAX_ITEMS;
	}
}
