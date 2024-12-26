package com.learn.designpattern.behavioral.null_object_pattern.p1;

public final class Car implements IVehicle {
	
	@Override
	public void drive() {
		System.out.println("You're driving a car!");
	}
}
