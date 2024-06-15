package com.learn.designpattern.behavioral.strategy.p1;

public class NormalDriveStrategy implements IDriveStrategy {
	
	@Override
	public void drive() {
		System.out.println("Vehicle is running at normal speed!");
	}
}
