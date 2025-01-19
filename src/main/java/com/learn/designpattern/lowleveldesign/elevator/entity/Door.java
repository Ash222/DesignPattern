package com.learn.designpattern.lowleveldesign.elevator.entity;

public abstract class Door {
	
	private DoorState doorState;
	
	public Door(final DoorState doorState) {
		this.doorState = doorState;
	}
	
	public DoorState getDoorState() {
		return doorState;
	}
	
	public void setDoorState(final DoorState doorState) {
		this.doorState = doorState;
	}
}
