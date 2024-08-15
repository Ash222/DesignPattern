package com.learn.designpattern.lowleveldesign.parkinglot.service;

import com.learn.designpattern.lowleveldesign.parkinglot.models.Gate;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingLot;

public class GateService {
	
	private final ParkingLot parkingLot;
	
	public GateService(final ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	/* Step :
	* 1. Iterate over all the gateList in the ParkingLot and get the gate. */
	public Gate getGateDetails(final int gateId) {
		
		Gate gate = null;
		
		for(Gate tempGate : parkingLot.getGateList()){
			
			if(gateId == tempGate.getId()){
				gate = tempGate;
				break;
			}
		}
		
		return gate;
	}
}
