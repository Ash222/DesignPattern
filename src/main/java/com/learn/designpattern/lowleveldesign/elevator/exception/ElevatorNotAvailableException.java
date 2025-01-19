package com.learn.designpattern.lowleveldesign.elevator.exception;

public class ElevatorNotAvailableException extends RuntimeException {
	public ElevatorNotAvailableException(final String message) {
		super(message);
	}
}
