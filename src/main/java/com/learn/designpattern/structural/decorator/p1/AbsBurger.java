package com.learn.designpattern.structural.decorator.p1;

public abstract class AbsBurger {
	
	private static int burgerCounter = 0;
	private final int burgerId;
	
	public AbsBurger() {
		this(true);
	}
	
	protected AbsBurger(final boolean isIncrementCounter) {
		
		if (isIncrementCounter) {
			this.burgerId = ++burgerCounter;
		} else {
			this.burgerId = burgerCounter;
		}
	}
	
	abstract String burgerDescription();
	
	abstract int burgerCost();
	
	int getBurgerId() {
		return this.burgerId;
	}
}
