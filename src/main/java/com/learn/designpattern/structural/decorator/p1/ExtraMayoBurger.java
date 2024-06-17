package com.learn.designpattern.structural.decorator.p1;

public class ExtraMayoBurger extends AbsBurgerDecorator {
	
	public ExtraMayoBurger(AbsBurger burger) {
		super(burger);
	}
	
	@Override
	String burgerDescription() {
		return this.burger.burgerDescription() + " :: with extra mayo!";
	}
	
	@Override
	int burgerCost() {
		return this.burger.burgerCost() + 10;
	}
}
