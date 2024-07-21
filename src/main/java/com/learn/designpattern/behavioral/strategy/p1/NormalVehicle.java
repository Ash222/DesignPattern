package com.learn.designpattern.behavioral.strategy.p1;

public class NormalVehicle extends AbsVehicle {
	
	public NormalVehicle(IDriveStrategy driveStrategy) {
		super(driveStrategy);
	}
	
	@Override
	protected void driveVehicle() {
		System.out.println("This is a normal vehicle!");
		this.driveStrategy.drive();
	}
}
