package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.SpotStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

public class EVParkingSpot extends ParkingSpot {
	
	private Meter meter;
	
	public EVParkingSpot(int parkingNumber, VehicleType vehicleType,
	                     SpotStatus spotStatus) {
		super(parkingNumber, vehicleType, spotStatus);
		this.meter = new Meter();
	}
	
	public Meter getMeter() {
		return meter;
	}
	
	public void setMeter(Meter meter) {
		this.meter = meter;
	}
}
