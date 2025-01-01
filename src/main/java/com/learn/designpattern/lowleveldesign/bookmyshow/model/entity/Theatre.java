package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

import com.learn.designpattern.lowleveldesign.bookmyshow.model
		.enums.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class Theatre {
	
	private final long theatreId;
	private final Movie movie;
	private final List<Seat> seatList;
	private final List<Feature> featureList;
	private final double price;
	private final ReentrantReadWriteLock reentrantReadWriteLock;
	
	public Theatre(final long theatreId, final Movie movie, final List<Seat> seatList,
			final List<Feature> featureList, final double price) {
		this.theatreId = theatreId;
		this.movie = movie;
		this.seatList = seatList;
		this.featureList = featureList;
		this.price = price;
		this.reentrantReadWriteLock = new ReentrantReadWriteLock();
	}
	
	public long id() {
		return theatreId;
	}
	
	public Movie movie() {
		return movie;
	}
	
	public List<Seat> seatList() {
		return new ArrayList<>(seatList);
	}
	
	public List<Feature> featureList() {
		return new ArrayList<>(featureList);
	}
	
	public double price() {
		return price;
	}
	
	public ReentrantReadWriteLock.ReadLock getReadLock(){
		return reentrantReadWriteLock.readLock();
	}
	
	public ReentrantReadWriteLock.WriteLock getWriteLock(){
		return reentrantReadWriteLock.writeLock();
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Theatre{");
		sb.append("id=").append(theatreId);
		sb.append(", movie=").append(movie);
		sb.append(", seatList=").append(seatList);
		sb.append(", featureList=").append(featureList);
		sb.append(", price=").append(price);
		sb.append('}');
		return sb.toString();
	}
}
