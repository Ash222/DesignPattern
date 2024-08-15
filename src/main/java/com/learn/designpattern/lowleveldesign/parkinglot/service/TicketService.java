package com.learn.designpattern.lowleveldesign.parkinglot.service;

import com.learn.designpattern.lowleveldesign.parkinglot.api.IParkingSpotAssignmentStrategy;
import com.learn.designpattern.lowleveldesign.parkinglot.exceptions.NoParkingSpotException;
import com.learn.designpattern.lowleveldesign.parkinglot.exceptions.NoTicketGenerateException;
import com.learn.designpattern.lowleveldesign.parkinglot.models.Gate;
import com.learn.designpattern.lowleveldesign.parkinglot.models.ParkingSpot;
import com.learn.designpattern.lowleveldesign.parkinglot.models.Ticket;
import com.learn.designpattern.lowleveldesign.parkinglot.models.Vehicle;
import com.learn.designpattern.lowleveldesign.parkinglot.models.enums.VehicleType;

import java.util.Date;

public class TicketService {
	
	private final VehicleService vehicleService;
	private final GateService gateService;
	private IParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;
	
	public TicketService(final VehicleService vehicleService,
	                     final GateService gateService) {
		this.vehicleService = vehicleService;
		this.gateService = gateService;
	}
	
	public void setParkingSpotAssignmentStrategy(final IParkingSpotAssignmentStrategy
			                                             parkingSpotAssignmentStrategy) {
		this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
	}
	
	/* Steps :
	 * 1. Get the vehicle details from the DB.
	 * 2. If the vehicle is there, fetch the details. Otherwise,
	 *    create the vehicle and store it in the DB.
	 * 3. Get the gate details from the DB. */
	public Ticket generateTicket(final String vehicleNumber,
	                             final VehicleType vehicleType,
	                             final int gateId) throws NoTicketGenerateException {
		
		final Vehicle vehicle = vehicleService
				.getVehicleDetails(vehicleNumber,vehicleType);
		final Gate gate = gateService.getGateDetails(gateId);
		ParkingSpot parkingSpot;
		try {
			
			parkingSpot = parkingSpotAssignmentStrategy.assignSpot(vehicleType);
			// if everything is fine then ticket is generated.
			return new Ticket(new Date(System.currentTimeMillis()), gate, vehicle,
			                  parkingSpot);
		} catch (NoParkingSpotException e) {
			e.printStackTrace();
		}
		
		throw new NoTicketGenerateException("");
	}
}
