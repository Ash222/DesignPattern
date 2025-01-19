package com.learn.designpattern.lowleveldesign.elevator.entity;

public class Floor {
	
	private final int floorNumber;
	private final IButton floorButton;
	private final Display floorDisplay;
	private final Door floorDoor;
	
	// initial state of the floor
	public Floor(final int floorNumber) {
		this.floorNumber = floorNumber;
		this.floorButton = new FloorButton();
		this.floorDisplay = new Display();
		this.floorDoor = new FloorDoor(DoorState.CLOSED);
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}
	
	public IButton getFloorButton() {
		return floorButton;
	}
	
	public Display getFloorDisplay() {
		return floorDisplay;
	}
	
	public Door getFloorDoor() {
		return floorDoor;
	}
}
