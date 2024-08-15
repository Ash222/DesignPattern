package com.learn.designpattern.lowleveldesign.parkinglot.controller;

import com.learn.designpattern.lowleveldesign.parkinglot.dto.TicketRequestDTO;
import com.learn.designpattern.lowleveldesign.parkinglot.dto.TicketResponseDTO;
import com.learn.designpattern.lowleveldesign.parkinglot.exceptions.NoTicketGenerateException;
import com.learn.designpattern.lowleveldesign.parkinglot.models.Ticket;
import com.learn.designpattern.lowleveldesign.parkinglot.service.TicketService;

public class TicketController {
	
	private final TicketService ticketService;
	
	public TicketController(final TicketService ticketService) {
		this.ticketService = ticketService;
	}
	
	
	public TicketResponseDTO generateTicket(TicketRequestDTO ticketRequestDTO) {
		
		Ticket ticket = null;
		TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
		
		try {
			
			ticket = ticketService.generateTicket(ticketRequestDTO.getVehicleNumber(),
			                                      ticketRequestDTO.getVehicleType(),
			                                      ticketRequestDTO.getGateId());
			ticketResponseDTO.setTicket(ticket);
		} catch (NoTicketGenerateException e) {
			e.printStackTrace();
			
		}
		
		return ticketResponseDTO;
	}
}
