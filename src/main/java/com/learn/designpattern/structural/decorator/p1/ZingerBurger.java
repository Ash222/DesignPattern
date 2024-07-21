package com.learn.designpattern.structural.decorator.p1;

public class ZingerBurger extends AbsBurger {
	
	@Override
	String burgerDescription() {
		return "Zinger Burger :: burgerId ::: " + this.getBurgerId();
	}
	
	@Override
	int burgerCost() {
		return 180;
	}
}
