package com.learn.designpattern.lowleveldesign.parkinglot.dto;

import com.learn.designpattern.lowleveldesign.parkinglot.models.Ticket;

public class TicketResponseDTO {
	
	private Ticket ticket;
	
	public Ticket getTicket() {
		return ticket;
	}
	
	public void setTicket(final Ticket ticket) {
		this.ticket = ticket;
	}
}
