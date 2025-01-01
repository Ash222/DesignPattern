package com.learn.designpattern.lowleveldesign.bookmyshow.exception;

public class SeatNotAvailableException extends Exception {
	
	public SeatNotAvailableException(final String message) {
		super(message);
	}
}
