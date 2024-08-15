package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.SpotStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

public class ParkingSpot {
	
	private final int id;
	private final int parkingNumber;
	private final VehicleType vehicleType;
	private SpotStatus spotStatus;
	
	public ParkingSpot(int parkingNumber, VehicleType vehicleType,
	                   SpotStatus spotStatus) {
		this.id = IDAllocatorUtil.getParkingSpotId();
		this.parkingNumber = parkingNumber;
		this.vehicleType = vehicleType;
		this.spotStatus = spotStatus;
	}
	
	public int getId() {
		return id;
	}
	
	public int getParkingNumber() {
		return parkingNumber;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public SpotStatus getSpotStatus() {
		return spotStatus;
	}
	
	public void setSpotStatus(SpotStatus spotStatus) {
		this.spotStatus = spotStatus;
	}
}
