package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

import java.util.List;

public class ParkingFloor {
	
	private final int id;
	private final int parkingFloorNumber;
	private List<ParkingSpot> parkingSpotList;
	
	public ParkingFloor(int parkingFloorNumber, List<ParkingSpot> parkingSpotList) {
		this.id = IDAllocatorUtil.getParkingFloorId();
		this.parkingFloorNumber = parkingFloorNumber;
		this.parkingSpotList = parkingSpotList;
	}
	
	public int getId() {
		return id;
	}
	
	public int getParkingFloorNumber() {
		return parkingFloorNumber;
	}
	
	public List<ParkingSpot> getParkingSpotList() {
		return parkingSpotList;
	}
	
	public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
		this.parkingSpotList = parkingSpotList;
	}
}
