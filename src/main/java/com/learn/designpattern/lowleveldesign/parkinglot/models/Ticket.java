package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

import java.util.Date;

public class Ticket {
	
	private final int id;
	private final Date entryTime;
	private final Gate gate;
	private final Vehicle vehicle;
	private final ParkingSpot parkingSpot;
	
	public Ticket(Date entryTime, Gate gate, Vehicle vehicle,
	              ParkingSpot parkingSpot) {
		this.id = IDAllocatorUtil.getTicketId();
		this.entryTime = entryTime;
		this.gate = gate;
		this.vehicle = vehicle;
		this.parkingSpot = parkingSpot;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getEntryTime() {
		return entryTime;
	}
	
	public Gate getGate() {
		return gate;
	}
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}
}
