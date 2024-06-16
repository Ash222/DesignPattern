package com.learn.designpattern.behavioral.null_object_pattern.p1;

public class Main {
	
	public static void main(String[] args) {
		
		IVehicle vehicle = null;
		
		if (vehicle == null) {
			vehicle = new NullVehicle();
		}
		
		vehicle.drive();
	}
}
