package com.learn.designpattern.lowleveldesign.bookmyshow.controller;

import com.learn.designpattern.lowleveldesign.bookmyshow.exception
		.SeatNotAvailableException;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Movie;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Seat;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Ticket;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.User;
import com.learn.designpattern.lowleveldesign.bookmyshow.service.BookingService;

import java.util.List;
import java.util.Set;

public class BookingController {
	
	private final BookingService bookingService;
	
	private BookingController(final BookingService bookingService) {
		this.bookingService = bookingService;
	}
	
	private static final class BookingControllerSingleton {
		private static final BookingController INSTANCE = new BookingController(
				BookingService.getInstance()
		);
	}
	
	public static BookingController getInstance() {
		return BookingControllerSingleton.INSTANCE;
	}
	
	public Set<Movie> getAllMovies() {
		return bookingService.getAllMovies();
	}
	
	public List<String> getAuditoriumForMovieSelected(final long movieId) {
		return bookingService.getAuditoriumForMovieSelected(movieId);
	}
	
	public List<Seat> getAllSeatForSelectedAuditoriumAndMovie(
			final long auditoriumId, final long movieId)
			throws SeatNotAvailableException {
		return bookingService.getAllSeatForSelectedAuditoriumAndMovie(auditoriumId,
		                                                              movieId);
	}
	
	public Ticket bookMovieSeat(final User user, final long auditoriumId,
			final long movieId, final List<Long> seatIdList) throws
			SeatNotAvailableException {
		return bookingService.bookMovieSeat(user, auditoriumId, movieId, seatIdList);
	}
}
