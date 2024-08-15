package com.learn.designpattern.lowleveldesign.parkinglot.service;

import com.learn.designpattern.lowleveldesign.parkinglot.dao.VehicleDAO;
import com.learn.designpattern.lowleveldesign.parkinglot.models.Vehicle;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

public class VehicleService {
	
	private VehicleDAO vehicleDAO;
	
	public VehicleService(final VehicleDAO vehicleDAO) {
		this.vehicleDAO = vehicleDAO;
	}
	
	public Vehicle getVehicleDetails(final String vehicleNumber,
	                                 final VehicleType vehicleType) {
		
		Vehicle vehicle = vehicleDAO.getVehicleDetails(vehicleNumber, vehicleType);
		
		if (vehicle == null) {
			vehicle = saveAndUpdateVehicleDetails(vehicleNumber, vehicleType);
		}
		
		return vehicle;
	}
	
	private Vehicle saveAndUpdateVehicleDetails(final String vehicleNumber,
	                                  final VehicleType vehicleType) {
		return null;
	}
}
