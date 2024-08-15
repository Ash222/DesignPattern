package com.learn.designpattern.lowleveldesign.parkinglot.dto;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

public class TicketRequestDTO {
	
	private int gateId;
	private String vehicleNumber;
	private VehicleType vehicleType;
	
	public int getGateId() {
		return gateId;
	}
	
	public void setGateId(final int gateId) {
		this.gateId = gateId;
	}
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	
	public void setVehicleNumber(final String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	
	public VehicleType getVehicleType() {
		return vehicleType;
	}
	
	public void setVehicleType(final VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}
}
