package com.learn.designpattern.lowleveldesign.elevator.exception;

public class SameFloorException extends RuntimeException {
	public SameFloorException(final String message) {
		super(message);
	}
}
