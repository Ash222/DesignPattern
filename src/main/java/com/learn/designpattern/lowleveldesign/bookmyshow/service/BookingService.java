package com.learn.designpattern.lowleveldesign.bookmyshow.service;

import com.learn.designpattern.lowleveldesign.bookmyshow.exception
		.SeatNotAvailableException;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Auditorium;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Movie;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Seat;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Theatre;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Ticket;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.User;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.enums.SeatAvailability;
import com.learn.designpattern.lowleveldesign.bookmyshow.model_design_pattern
		.TicketBuilder;
import com.learn.designpattern.lowleveldesign.bookmyshow.repository.BookingRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BookingService {
	
	private final BookingRepository bookingRepository;
	private final Map<Long, List<Theatre>> auditoriumIdVsTheatreListMap;
	
	private BookingService(final BookingRepository bookingRepository) {
		auditoriumIdVsTheatreListMap = new HashMap<>();
		this.bookingRepository = bookingRepository;
		init();
	}
	
	private static final class BookingServiceSingleton {
		private static final BookingService INSTANCE = new BookingService(
				BookingRepository.getInstance()
		);
	}
	
	// this will load the initial data.
	public void init() {
		
		final List<Auditorium> auditoriumList = bookingRepository.getAuditoriumList();
		
		for (final Auditorium auditorium : auditoriumList) {
			auditoriumIdVsTheatreListMap.put(auditorium.auditoriumId(),
			                                 new ArrayList<>(auditorium.theatreList()));
		}
		
		System.out.println("BookingService :: init :: auditoriumIdVsTheatreListMap ::: "
				                   + auditoriumIdVsTheatreListMap);
	}
	
	public static BookingService getInstance() {
		return BookingServiceSingleton.INSTANCE;
	}
	
	public Set<Movie> getAllMovies() {
		
		Set<Movie> movieSet = new HashSet<>();
		
		for (final List<Theatre> theatreList : auditoriumIdVsTheatreListMap.values()) {
			for (final Theatre theatre : theatreList) {
				movieSet.add(theatre.movie());
			}
		}
		
		System.out.println("BookingService :: getAllMovies :: movieSet ::: "
				                   + movieSet);
		
		return movieSet;
	}
	
	public List<String> getAuditoriumForMovieSelected(final long movieId) {
		
		final List<String> auditoriumNameList = new ArrayList<>();
		
		for (final Map.Entry<Long, List<Theatre>> keyValue : auditoriumIdVsTheatreListMap
				.entrySet()) {
			for (final Theatre theatre : keyValue.getValue()) {
				if (movieId == theatre.movie().movieId()) {
					auditoriumNameList.add(keyValue.getKey() + " : "
							                       + bookingRepository.getAuditoriumName(
							keyValue.getKey())
					);
				}
			}
		}
		
		System.out.println("BookingService :: getAuditoriumForMovieSelected ::" +
				                   "auditoriumNameList ::: " + auditoriumNameList);
		
		return auditoriumNameList;
	}
	
	/*
		Issues in the Code :
		Inefficient Locking and Unlocking:
			The lock is acquired and released inside the loop for each seat, making the
			code less efficient.
			This frequent locking and unlocking might degrade performance, especially when
			dealing with a large number of seats, as locking mechanisms can introduce
			overhead.
		Lock Contention:
			If multiple threads are accessing the same set of seats simultaneously,
			frequent contention for locks may cause delays.
		Write Starvation:
			If multiple threads are concurrently get the read lock then the thread waiting
			for the write lock will have to wait infinitely.
		
		Advantages :
		It avoids the problem where one thread could read an "in-between" state where a
		seat is in the process of being booked but not yet fully marked as booked. The
		below code correctly ensures that the application's view of seat availability is
		consistent and accurate, even under high concurrency.

	*/
	public List<Seat> getAllSeatForSelectedAuditoriumAndMovie(
			final long auditoriumId, final long movieId
	) {
		
		final List<Seat> availableSeatList = new ArrayList<>();
		
		for (final Theatre theatre : auditoriumIdVsTheatreListMap.get(auditoriumId)) {
			if (movieId == theatre.movie().movieId()) {
				// acquire the theatre level lock
				theatre.getReadLock().lock(); // necessary for theatre level
				// modification, i.e., no adding or removing of seats
				try {
					for (final Seat seat : theatre.seatList()) {
						// acquire read lock so that reading the seat will always be
						// consistent no matter the number of users.
						seat.getReadLock().lock();
						try {
							if (seat.getSeatAvailability() == SeatAvailability
									.AVAILABLE) {
								availableSeatList.add(seat);
							}
						} finally {
							seat.getReadLock().unlock();
						}
					}
				} finally {
					theatre.getReadLock().unlock();
				}
			}
		}
		
		return availableSeatList;
	}
	
	// We're using seat level exclusive lock because in this method we're changing the
	// seatAvailability of seat class. Hence, granular seat lock mechanism is needed,
	// even though it will lead to performance issue because lock are being acquired in
	// loop.
	public Ticket bookMovieSeat(final User user, final long auditoriumId,
			final long movieId, final List<Long> seatIdList)
			throws SeatNotAvailableException {
		
		final List<Seat> lockedSeatList = new ArrayList<>();
		final List<Long> bookedSeatIdList = new ArrayList<>();
		String movieName = "";
		long theatreId = 0;
		
		try {
			
			for (final Theatre theatre : auditoriumIdVsTheatreListMap.get(auditoriumId)) {
				if (movieId == theatre.movie().movieId()) {
					
					theatreId = theatre.id();
					movieName = theatre.movie().movieName();
					
					for (final long seatId : seatIdList) {
						for (Seat seat : theatre.seatList()) {
							if (seatId == seat.getSeatId()) {
								// get exclusive lock on the seat to change the seat
								// availability
								if (seat.getWriteLock().tryLock(2, TimeUnit.SECONDS
								)) {
									// track the locked seats to unlock them
									lockedSeatList.add(seat);
									
									if (seat.getSeatAvailability() == SeatAvailability
											.AVAILABLE) {
										seat.setSeatAvailability(SeatAvailability.BOOKED);
										bookedSeatIdList.add(seatId);
									} else {
										throw new SeatNotAvailableException(
												"Seat id " + seatId + " is not " +
														"available at the moment, please"
														+ " refresh the page and book " +
														"other seat."
										);
									}
								} else {
									throw new SeatNotAvailableException(
											"Seat id " + seatId + " is not unlocked at " +
													"the moment, please refresh the " +
													"page and try again later."
									);
								}
							}
						}
					}
				}
			}
		} catch (InterruptedException e) {
			System.out.println("BookingService :: bookMovieSeat :: InterruptedException");
		} finally {
			// unlock all the locked seats
			for (final Seat seat : lockedSeatList) {
				seat.getWriteLock().unlock();
			}
		}
		
		return createTicket(user, auditoriumId, theatreId, movieId, movieName,
		                    bookedSeatIdList);
	}
	
	private Ticket createTicket(final User user, final long auditoriumId,
			final long theatreId, final long movieId, final String movieName,
			final List<Long> bookedSeatIdList) {
		return TicketBuilder.builder()
		                    .userId(user.userId())
		                    .userName(user.userName())
		                    .auditoriumId(auditoriumId)
		                    .auditoriumName(
									bookingRepository.getAuditoriumName(auditoriumId)
		                    )
		                    .seatList(bookedSeatIdList)
		                    .ticketPrice(
				                    totalPriceOfSeats(
						                    auditoriumId, theatreId, movieId
				                    )
		                    )
		                    .build();
	}
	
	public double totalPriceOfSeats(final long auditoriumId,
			final long theatreId, final long movieId) {
		
		double totalPrice = 0;
		
		for (final Theatre theatre : auditoriumIdVsTheatreListMap.get(auditoriumId)) {
			if (theatre.id() == theatreId) {
				totalPrice += theatre.price() + theatre.movie().moviePrice();
			}
		}
		
		return totalPrice;
	}
}
