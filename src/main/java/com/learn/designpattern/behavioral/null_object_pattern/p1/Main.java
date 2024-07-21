package com.learn.designpattern.behavioral.null_object_pattern.p1;

public class Main {
	
	public static void main(String[] args) {
		
		// let assume this is coming from other method, then the advantage with this
		// pattern is that we don't have to do null on the vehicle object.
		IVehicle vehicle = new NullVehicle();
		
		vehicle.drive();
	}
}
