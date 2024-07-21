package com.learn.designpattern.behavioral.strategy.p1;

public class SportVehicle extends AbsVehicle {
	
	public SportVehicle(IDriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
	@Override
	protected void driveVehicle() {
		System.out.println("This is a sports vehicle!");
		this.driveStrategy.drive();
	}
}
