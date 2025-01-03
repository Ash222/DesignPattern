package com.learn.designpattern.lowleveldesign.bookmyshow.repository;

import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Auditorium;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Movie;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Seat;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.entity.Theatre;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.enums.Feature;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.enums.SeatAvailability;
import com.learn.designpattern.lowleveldesign.bookmyshow.model.enums.SeatType;

import java.util.ArrayList;
import java.util.List;

public class BookingRepository {
	
	private final List<Auditorium> auditoriumList;
	
	private BookingRepository() {
		auditoriumList = new ArrayList<>();
		init();
	}
	
	private static final class BookingRepositorySingleton {
		private static final BookingRepository INSTANCE = new BookingRepository();
	}
	
	public static BookingRepository getInstance() {
		return BookingRepositorySingleton.INSTANCE;
	}
	
	// Consider this method will load the data initially from the
	// db. This method will mimic the db calls for fetching all the
	// auditorium.
	public void init() {
		
		// movies
		Movie m1 = new Movie(1, "movie1", 100,
		                     2,
		                     List.of(Feature.TWO_D, Feature.THREE_D));
		Movie m2 = new Movie(2, "movie2", 200,
		                     3,
		                     List.of(Feature.TWO_D, Feature.DOLBY));
		Movie m3 = new Movie(3, "movie3", 300,
		                     3,
		                     List.of(Feature.TWO_D, Feature.DOLBY));
		Movie m4 = new Movie(4, "movie4", 200,
		                     1,
		                     List.of(Feature.THREE_D, Feature.DOLBY));
		Movie m5 = new Movie(5, "movie5", 600,
		                     4,
		                     List.of(Feature.TWO_D, Feature.THREE_D));
		Movie m6 = new Movie(6, "movie6", 350,
		                     3, List.of(Feature.TWO_D));
		
		// seats
		Seat s1 = new Seat(1, SeatType.NORMAL, SeatAvailability.AVAILABLE);
		Seat s2 = new Seat(2, SeatType.NORMAL, SeatAvailability.AVAILABLE);
		Seat s3 = new Seat(3, SeatType.PREMIUM, SeatAvailability.AVAILABLE);
		Seat s4 = new Seat(4, SeatType.PREMIUM, SeatAvailability.AVAILABLE);
		Seat s5 = new Seat(5, SeatType.PREMIUM, SeatAvailability.AVAILABLE);
		Seat s6 = new Seat(6, SeatType.NORMAL, SeatAvailability.AVAILABLE);
		Seat s7 = new Seat(7, SeatType.NORMAL, SeatAvailability.AVAILABLE);
		
		// theatres
		Theatre t1 = new Theatre(1, m1, List.of(s1, s2, s3, s4, s5, s6, s7),
		                         List.of(Feature.TWO_D, Feature.THREE_D, Feature.DOLBY),
		                         10);
		Theatre t2 = new Theatre(2, m3, List.of(s1, s2, s3, s4, s5),
		                         List.of(Feature.TWO_D, Feature.DOLBY), 8);
		Theatre t3 = new Theatre(3, m4, List.of(s1, s2, s3, s4, s5, s6, s7),
		                         List.of(Feature.THREE_D, Feature.DOLBY), 6);
		Theatre t4 = new Theatre(1, m6, List.of(s1, s2, s3, s4, s5),
		                         List.of(Feature.TWO_D), 4);
		Theatre t5 = new Theatre(2, m2, List.of(s1, s2, s3, s4, s5, s6, s7),
		                         List.of(Feature.TWO_D, Feature.THREE_D, Feature.DOLBY),
		                         11);
		Theatre t6 = new Theatre(1, m5, List.of(s1, s2, s3, s4, s5, s6, s7),
		                         List.of(Feature.TWO_D, Feature.THREE_D, Feature.DOLBY),
		                         10);
		
		// auditorium
		Auditorium a1 = new Auditorium(1, "auditorium1",
		                               List.of(t1, t2, t3), 10);
		Auditorium a2 = new Auditorium(2, "auditorium2",
		                               List.of(t4, t5), 18);
		Auditorium a3 = new Auditorium(3, "auditorium3",
		                               List.of(t6), 12);
		
		auditoriumList.add(a1);
		auditoriumList.add(a2);
		auditoriumList.add(a3);
	}
	
	public List<Auditorium> getAuditoriumList() {
		return new ArrayList<>(auditoriumList);
	}
	
	public String getAuditoriumName(final long auditoriumId) {
		for (final Auditorium auditorium : auditoriumList) {
			if (auditoriumId == auditorium.auditoriumId()) {
				return auditorium.auditoriumName();
			}
		}
		return null;
	}
}
