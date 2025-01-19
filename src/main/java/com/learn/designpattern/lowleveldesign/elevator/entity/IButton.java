package com.learn.designpattern.lowleveldesign.elevator.entity;

public sealed interface IButton permits FloorButton, ElevatorButton {
	void press(int floorNumber);
}
