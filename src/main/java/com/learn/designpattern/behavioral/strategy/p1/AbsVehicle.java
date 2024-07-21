package com.learn.designpattern.behavioral.strategy.p1;

public abstract class AbsVehicle {
	
	protected IDriveStrategy driveStrategy;
	
	public AbsVehicle(IDriveStrategy driveStrategy) {
		this.driveStrategy = driveStrategy;
	}
	
	protected abstract void driveVehicle();
}
