package com.learn.designpattern.structural.decorator.p1;

public abstract class AbsBurgerDecorator extends AbsBurger {
	
	protected AbsBurger burger;
	
	public AbsBurgerDecorator(final AbsBurger burger) {
		super(false);
		this.burger = burger;
	}
}
