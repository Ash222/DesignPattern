package com.learn.designpattern.behavioral.strategy.p1;

public class Main {
	
	public static void main(String[] args) {
		
		IDriveStrategy driveStrategy = new NormalDriveStrategy();
		// IDriveStrategy driveStrategy = new SportDriveStrategy();
		AbsVehicle vehicle = new SportVehicle(driveStrategy);
		// AbsVehicle vehicle = new NormalVehicle(driveStrategy);
		vehicle.driveVehicle();
	}
}
