package com.learn.designpattern.behavioral.strategy.p1;

public abstract class AbsVehicle {
	
	protected final IDriveStrategy driveStrategy;
	
	public AbsVehicle(final IDriveStrategy driveStrategy) {
		this.driveStrategy = driveStrategy;
	}
	
	protected abstract void driveVehicle();
}
