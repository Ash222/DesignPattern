package com.learn.designpattern.lowleveldesign.parkinglot.api;

import com.learn.designpattern.lowleveldesign.parkinglot.exceptions.NoParkingSpotException;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingSpot;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

public interface IParkingSpotAssignmentStrategy {
	ParkingSpot assignSpot(VehicleType vehicleType) throws NoParkingSpotException;
}
