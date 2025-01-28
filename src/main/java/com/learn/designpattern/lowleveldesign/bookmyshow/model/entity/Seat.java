package com.learn.designpattern.lowleveldesign.bookmyshow.model.entity;

import com.learn.designpattern.lowleveldesign.bookmyshow.model.enums.SeatAvailability;
import com.learn.designpattern.lowleveldesign.bookmyshow.model
		.enums.SeatType;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class Seat {
	
	private final long seatId;
	private final SeatType seatType;
	private SeatAvailability seatAvailability;
	private final ReentrantReadWriteLock reentrantReadWriteLock;
	
	public Seat(long seatId, SeatType seatType, SeatAvailability seatAvailability) {
		this.seatId = seatId;
		this.seatType = seatType;
		this.seatAvailability = seatAvailability;
		this.reentrantReadWriteLock = new ReentrantReadWriteLock(true); // fair locking
	}
	
	public long getSeatId() {
		return seatId;
	}
	
	public SeatType getSeatType() {
		return seatType;
	}
	
	// Only concurrent read are valid (shared lock)
	public SeatAvailability getSeatAvailability() {
		reentrantReadWriteLock.readLock().lock();
		try {
			return seatAvailability;
		} finally {
			reentrantReadWriteLock.readLock().unlock();
		}
	}
	
	// Only one thread can get exclusive lock (read-write lock)
	public void setSeatAvailability(final SeatAvailability seatAvailability) {
		reentrantReadWriteLock.writeLock().lock();
		try {
			this.seatAvailability = seatAvailability;
		} finally {
			reentrantReadWriteLock.writeLock().unlock();
		}
	}
	
	// Get read lock on seat (shared lock)
	public ReentrantReadWriteLock.ReadLock getReadLock() {
		return reentrantReadWriteLock.readLock();
	}
	
	// Get read-write lock (exclusive lock)
	public ReentrantReadWriteLock.WriteLock getWriteLock() {
		return reentrantReadWriteLock.writeLock();
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Seat{");
		sb.append("seatId=").append(seatId);
		sb.append("seatAvailability=")
		  .append(seatAvailability.toString());
		sb.append(", seatType=").append(seatType.toString());
		sb.append('}');
		return sb.toString();
	}
}
