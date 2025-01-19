package com.learn.designpattern.lowleveldesign.elevator.controller;

import com.learn.designpattern.lowleveldesign.elevator.entity.MovingDirection;
import com.learn.designpattern.lowleveldesign.elevator.service.ElevatorService;

public class ElevatorController {
	
	private final ElevatorService elevatorService;
	
	public ElevatorController(final ElevatorService elevatorService) {
		this.elevatorService = elevatorService;
	}
	
	public void pressFloorButton(final int currentFloorNumber,
			final MovingDirection movingDirection) {
		elevatorService.pressFloorButton(currentFloorNumber, movingDirection);
	}
	
	public void pressElevatorButton(final int fromFloorNumber, final int toFloorNumber,
			final int elevatorNumber) {
		elevatorService.pressElevatorButton(fromFloorNumber, toFloorNumber,
		                                    elevatorNumber);
	}
	
	public void elevatorPositionDisplay() {
		elevatorService.elevatorPositionDisplay();
	}
}
