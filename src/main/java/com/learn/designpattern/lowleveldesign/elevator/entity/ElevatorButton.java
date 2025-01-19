package com.learn.designpattern.lowleveldesign.elevator.entity;

public final class ElevatorButton implements IButton {
	
	@Override
	public void press(final int floorNumber) {
		System.out.println("Elevator button pressed :: " + floorNumber);
	}
}
