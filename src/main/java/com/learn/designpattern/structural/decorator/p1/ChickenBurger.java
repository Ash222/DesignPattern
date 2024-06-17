package com.learn.designpattern.structural.decorator.p1;

public class ChickenBurger extends AbsBurger {
	
	@Override
	String burgerDescription() {
		return "Chicken Burger :: burgerId ::: " + this.getBurgerId();
	}
	
	@Override
	int burgerCost() {
		return 220;
	}
}
