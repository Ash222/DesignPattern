package com.learn.designpattern.structural.decorator.p1;

public class ExtraCheeseBurger extends AbsBurgerDecorator {
	
	public ExtraCheeseBurger(AbsBurger burger) {
		super(burger);
	}
	
	@Override
	String burgerDescription() {
		return this.burger.burgerDescription() + " :: with extra cheese!";
	}
	
	@Override
	int burgerCost() {
		return this.burger.burgerCost() + 30;
	}
}
