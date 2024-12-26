package com.learn.designpattern.behavioral.null_object_pattern.p1;

public final class NullVehicle implements IVehicle{
	
	@Override
	public void drive() {
		System.out.println("No vehicle object!");
	}
}
