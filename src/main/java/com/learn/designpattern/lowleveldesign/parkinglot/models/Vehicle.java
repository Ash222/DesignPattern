package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

public class Vehicle {
	
	private final int id;
	private final String vehicleNumber;
	private final VehicleType vehicleType;
	
	public Vehicle(String vehicleNumber, VehicleType vehicleType) {
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.id = IDAllocatorUtil.getVehicleId();
	}
	
	public int getId() {
		return id;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
}
