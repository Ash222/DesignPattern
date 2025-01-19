package com.learn.designpattern.lowleveldesign.elevator.entity;

public final class FloorButton implements IButton {
	
	@Override
	public void press(final int floorNumber) {
		System.out.println("Floor button pressed :: " + floorNumber);
	}
}
