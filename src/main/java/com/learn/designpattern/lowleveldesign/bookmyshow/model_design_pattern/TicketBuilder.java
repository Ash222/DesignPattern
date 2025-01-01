package com.learn.designpattern.lowleveldesign.bookmyshow.model_design_pattern;

import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketBuilder {
	
	private long userId;
	private String userName;
	private long auditoriumId;
	private String auditoriumName;
	private long movieId;
	private String movieName;
	private List<Long> seatList;
	private double ticketPrice;
	
	private TicketBuilder() {
	}
	
	public long getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public List<Long> getSeatList() {
		return new ArrayList<>(seatList);
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	public long getAuditoriumId() {
		return auditoriumId;
	}
	
	public String getAuditoriumName() {
		return auditoriumName;
	}
	
	public long getMovieId() {
		return movieId;
	}
	
	public String getMovieName() {
		return movieName;
	}
	
	public TicketBuilder userId(final long userId) {
		this.userId = userId;
		return this;
	}
	
	public TicketBuilder userName(final String userName) {
		this.userName = userName;
		return this;
	}
	
	public TicketBuilder seatList(final List<Long> seatList) {
		this.seatList = new ArrayList<>(seatList);
		return this;
	}
	
	public TicketBuilder ticketPrice(final double ticketPrice) {
		this.ticketPrice = ticketPrice;
		return this;
	}
	
	public TicketBuilder auditoriumId(final long auditoriumId) {
		this.auditoriumId = auditoriumId;
		return this;
	}
	
	public TicketBuilder auditoriumName(final String auditoriumName) {
		this.auditoriumName = auditoriumName;
		return this;
	}
	
	public TicketBuilder movieId(final long movieId) {
		this.movieId = movieId;
		return this;
	}
	
	public TicketBuilder movieName(final String movieName) {
		this.movieName = movieName;
		return this;
	}
	
	public static TicketBuilder builder() {
		return new TicketBuilder();
	}
	
	public Ticket build() {
		return new Ticket(this);
	}
}
