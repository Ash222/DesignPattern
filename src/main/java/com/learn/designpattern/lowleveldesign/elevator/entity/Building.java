package com.learn.designpattern.lowleveldesign.elevator.entity;

import java.util.ArrayList;
import java.util.List;

public class Building {
	
	private final int buildingNumber;
	private final List<Elevator> elevatorList;
	private final List<Floor> floorList;
	
	// initial state of the building
	public Building(final int buildingNumber) {
		this.buildingNumber = buildingNumber;
		this.elevatorList = new ArrayList<>();
		this.floorList = new ArrayList<>();
	}
	
	public int getBuildingNumber() {
		return buildingNumber;
	}
	
	public List<Elevator> getElevatorList() {
		return elevatorList;
	}
	
	public List<Floor> getFloorList() {
		return floorList;
	}
	
	public void addElevators(final Elevator elevator) {
		this.elevatorList.add(elevator);
	}
	
	public void addFloor(final Floor floor) {
		this.floorList.add(floor);
	}
}
