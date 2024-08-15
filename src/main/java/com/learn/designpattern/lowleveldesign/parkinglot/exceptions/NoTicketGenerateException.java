package com.learn.designpattern.lowleveldesign.parkinglot.exceptions;

public class NoTicketGenerateException extends Exception {
	public NoTicketGenerateException(String message) {
		super(message);
	}
}
