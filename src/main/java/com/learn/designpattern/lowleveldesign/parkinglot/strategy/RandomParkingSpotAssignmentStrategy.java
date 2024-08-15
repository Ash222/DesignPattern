package com.learn.designpattern.lowleveldesign.parkinglot.strategy;

import com.learn.designpattern.lowleveldesign.parkinglot.api.IParkingSpotAssignmentStrategy;
import com.learn.designpattern.lowleveldesign.parkinglot.exceptions.NoParkingSpotException;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingFloor;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingLot;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingSpot;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.SpotStatus;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

public class RandomParkingSpotAssignmentStrategy implements
		IParkingSpotAssignmentStrategy {
	
	final ParkingLot parkingLot;
	
	public RandomParkingSpotAssignmentStrategy(final ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}
	
	/* Steps :
	 * 1. Checking if the spot is available in any of the floor, for the required
	 *    vehicleType.
	 * 2. If not then throw NoParkingSpotException. */
	@Override
	public ParkingSpot assignSpot(final VehicleType vehicleType)
			throws NoParkingSpotException {
		
		for (ParkingFloor parkingFloor : parkingLot.getParkingFloorList()) {
			for (ParkingSpot tempParkingSpot : parkingFloor.getParkingSpotList()) {
				
				boolean isParkingSpotAvailable = tempParkingSpot
						.getSpotStatus().equals(SpotStatus.AVAILABLE);
				boolean doesVehicleTypeMatch = tempParkingSpot
						.getVehicleType().equals(vehicleType);
				if (isParkingSpotAvailable && doesVehicleTypeMatch) {
					return tempParkingSpot;
				}
			}
		}
		
		throw new NoParkingSpotException("No parking spot for the " + vehicleType);
	}
}
