package com.learn.designpattern.lowleveldesign.elevator.entity;

public class Elevator {
	
	private final int elevatorNumber;
	private ElevatorState elevatorState;
	private final Display display;
	private final IButton elevatorButton;
	private final Door elevatorDoor;
	
	// initial state of the door
	public Elevator(final int elevatorNumber, final IButton elevatorButton) {
		this.elevatorNumber = elevatorNumber;
		this.elevatorButton = elevatorButton;
		this.elevatorState = ElevatorState.STOP;
		this.display = new Display();
		this.elevatorDoor = new ElevatorDoor(DoorState.CLOSED);
	}
	
	public int getElevatorNumber() {
		return elevatorNumber;
	}
	
	public ElevatorState getElevatorState() {
		return elevatorState;
	}
	
	public void setElevatorState(final ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}
	
	public Display getDisplay() {
		return display;
	}
	
	public IButton getElevatorButton() {
		return elevatorButton;
	}
	
	public Door getElevatorDoor() {
		return elevatorDoor;
	}
}
