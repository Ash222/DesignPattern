package com.learn.designpattern.lowleveldesign.parkinglot.utils;

public class IDAllocatorUtil {
	
	private static int parkingLotId;
	private static int parkingFloorId;
	private static int parkingSpotId;
	private static int billId;
	private static int meterId;
	private static int gateId;
	private static int ticketId;
	private static int paymentId;
	private static int vehicleId;
	
	private IDAllocatorUtil() {
	}
	
	static {
		parkingLotId = 0;
		parkingFloorId = 0;
		parkingSpotId = 0;
		meterId = 0;
		gateId = 0;
		ticketId = 0;
		billId = 0;
		paymentId = 0;
		vehicleId = 0;
	}
	
	public static int getVehicleId() {
		vehicleId++;
		return vehicleId;
	}
	
	public static int getPaymentId() {
		paymentId++;
		return paymentId;
	}
	
	public static int getParkingLotId() {
		parkingLotId++;
		return parkingLotId;
	}
	
	public static int getParkingFloorId() {
		parkingFloorId++;
		return parkingFloorId;
	}
	
	public static int getParkingSpotId() {
		parkingSpotId++;
		return parkingSpotId;
	}
	
	public static int getBillId() {
		billId++;
		return billId;
	}
	
	public static int getMeterId() {
		meterId++;
		return meterId;
	}
	
	public static int getGateId() {
		gateId++;
		return gateId;
	}
	
	public static int getTicketId() {
		ticketId++;
		return ticketId;
	}
}
