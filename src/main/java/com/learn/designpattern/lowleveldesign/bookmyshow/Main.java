package com.learn.designpattern.lowleveldesign.bookmyshow;

import com.learn.designpattern.lowleveldesign.bookmyshow.controller
		.BookingController;
import com.learn.designpattern.lowleveldesign.bookmyshow.exception.SeatNotAvailableException;
import com.learn.designpattern.lowleveldesign.bookmyshow.model
		.entity.Movie;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Seat;
import com.learn.designpattern.lowleveldesign.bookmyshow.model
		.entity.User;

import java.util.List;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) {
		
		// users
		User u1 = new User(1, "user1");
		User u2 = new User(2, "user2");
		User u3 = new User(3, "user3");
		
		try {
			
			final BookingController bookingController = BookingController.getInstance();
			final Set<Movie> movieList = bookingController.getAllMovies();
			final long selectedMovieId = 3;
			final long selectedAuditoriumId = 1;
			final List<String> auditoriumNameList = bookingController
					.getAuditoriumForMovieSelected(selectedMovieId);
			final List<Seat> availableSeatList = bookingController
					.getAllSeatForSelectedAuditoriumAndMovie(selectedAuditoriumId,
					                                         selectedMovieId);
			
			System.out.println("Main :: main :: movieList ::: " + movieList);
			System.out.println("Main :: main :: auditoriumNameList ::: "
					                   + auditoriumNameList);
			System.out.println("Main :: main :: availableSeatList ::: "
					                   + availableSeatList);
		} catch (SeatNotAvailableException e) {
			System.out.print("Main :: main :: SeatNotAvailableException ::: ");
			for (final StackTraceElement ste : e.getStackTrace()) {
				System.out.println(ste.toString());
			}
		}
	}
}
