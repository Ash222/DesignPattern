package com.learn.designpattern.lowleveldesign.parkinglot.models;

import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.ParkingLotStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.utils.IDAllocatorUtil;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
	
	private final int id;
	private String address;
	private final List<Gate> gateList;
	private final List<ParkingFloor> parkingFloorList;
	private ParkingLotStatus parkingLotStatus;
	
	public ParkingLot(String address) {
		this.id = IDAllocatorUtil.getParkingLotId();
		this.address = address;
		this.gateList = new ArrayList<>();
		this.parkingFloorList = new ArrayList<>();
		this.parkingLotStatus = ParkingLotStatus.OPEN;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public List<Gate> getGateList() {
		return gateList;
	}
	
	public void setGateList(List<Gate> gateList) {
		this.gateList.addAll(gateList);
	}
	
	public List<ParkingFloor> getParkingFloorList() {
		return parkingFloorList;
	}
	
	public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
		this.parkingFloorList.addAll(parkingFloorList);
	}
	
	public ParkingLotStatus getParkingLotStatus() {
		return parkingLotStatus;
	}
	
	public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
		this.parkingLotStatus = parkingLotStatus;
	}
}
