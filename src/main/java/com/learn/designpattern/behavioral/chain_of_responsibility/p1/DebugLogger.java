package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public final class DebugLogger extends AbsLogger {
	
	public DebugLogger(final LoggerLevel loggerLevel) {
		super(loggerLevel);
	}
	
	@Override
	public void displayMessage(final String message) {
		System.out.println("DEBUG ::: " + message);
	}
}
