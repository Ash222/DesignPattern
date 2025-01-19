package com.learn.designpattern.lowleveldesign.elevator.entity;

public final class Display {
	
	private int floorNumber;
	private MovingDirection movingDirection;
	
	public Display() {
		this.floorNumber = 0;
		this.movingDirection = MovingDirection.IDLE;
	}
	
	public int getFloorNumber() {
		return floorNumber;
	}
	
	public void setFloorNumber(final int floorNumber) {
		this.floorNumber = floorNumber;
	}
	
	public MovingDirection getMovingDirection() {
		return movingDirection;
	}
	
	public void setMovingDirection(final MovingDirection movingDirection) {
		this.movingDirection = movingDirection;
	}
}
