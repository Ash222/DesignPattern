package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public abstract sealed class AbsLogger permits DebugLogger, InfoLogger {
	
	protected AbsLogger nextHandler;
	protected final LoggerLevel loggerLevel;
	
	public AbsLogger(final LoggerLevel loggerLevel) {
		this.loggerLevel = loggerLevel;
	}
	
	protected void setNextHandler(final AbsLogger nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	protected void logMessage(final LoggerLevel loggerLevel, final String message) {
		
		// if this is able to handle the message then process
		// otherwise pass the handler to someone else to handle the message
		if (loggerLevel == this.loggerLevel) {
			displayMessage(message);
			return;
		}
		
		// let the next handler manage the processing
		if (this.nextHandler != null) {
			this.nextHandler.logMessage(loggerLevel, message);
		}
	}
	
	abstract void displayMessage(final String message);
}
