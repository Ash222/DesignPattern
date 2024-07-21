package com.learn.designpattern.behavioral.strategy.p1;

public class SportDriveStrategy implements IDriveStrategy {
	
	@Override
	public void drive() {
		System.out.println("Vehicle is running at a very fast speed!");
	}
}
