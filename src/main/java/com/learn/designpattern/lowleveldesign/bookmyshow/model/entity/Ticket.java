package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

import com.learn.designpattern.lowleveldesign.bookmyshow
		.model_design_pattern.TicketBuilder;

import java.util.ArrayList;
import java.util.List;

public final class Ticket {
	
	private final long ticketId;
	private final List<Long> seatList;
	private final long userId;
	private final String userName;
	private final long auditoriumId;
	private final String auditoriumName;
	private final long movieId;
	private final String movieName;
	private final double ticketPrice;
	private static long ticketIdCounter = 0;
	
	public Ticket(final TicketBuilder ticketBuilder) {
		this.ticketId = ++ticketIdCounter;
		this.seatList = ticketBuilder.getSeatList();
		this.userId = ticketBuilder.getUserId();
		this.userName = ticketBuilder.getUserName();
		this.ticketPrice = ticketBuilder.getTicketPrice();
		this.auditoriumId = ticketBuilder.getAuditoriumId();
		this.auditoriumName = ticketBuilder.getAuditoriumName();
		this.movieId = ticketBuilder.getMovieId();
		this.movieName = ticketBuilder.getMovieName();
	}
	
	public long getTicketId() {
		return ticketId;
	}
	
	public List<Long> getSeatList() {
		return new ArrayList<>(seatList);
	}
	
	public long getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Ticket{");
		sb.append("ticketId=").append(ticketId);
		sb.append(", seatList=").append(seatList);
		sb.append(", userId=").append(userId);
		sb.append(", userName='").append(userName).append('\'');
		sb.append(", ticketPrice=").append(ticketPrice);
		sb.append('}');
		return sb.toString();
	}
}
