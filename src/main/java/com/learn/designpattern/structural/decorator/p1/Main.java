package com.learn.designpattern.structural.decorator.p1;

public class Main {
	
	public static void main(String[] args) {
		
		AbsBurger burger1 = new ExtraCheeseBurger(new ChickenBurger());
		AbsBurger burger2 = new ChickenBurger();
		AbsBurger burger3 = new ExtraCheeseBurger(new ExtraMayoBurger(new ZingerBurger()));
		
		System.out.println(burger1.burgerDescription() + " :: cost ::: "
				+ burger1.burgerCost());
		System.out.println(burger2.burgerDescription() + " :: cost ::: "
				+ burger2.burgerCost());
		System.out.println(burger3.burgerDescription() + " :: cost ::: "
				+ burger3.burgerCost());
	}
}
