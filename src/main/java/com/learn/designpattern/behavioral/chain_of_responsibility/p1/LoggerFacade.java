package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public final class LoggerFacade {
	
	private final AbsLogger logger;
	
	private LoggerFacade() {
		this.logger = chainLogger();
	}
	
	private static final class LoggerFacadeSingleton {
		private static final LoggerFacade INSTANCE = new LoggerFacade();
	}
	
	public static LoggerFacade getInstance() {
		return LoggerFacadeSingleton.INSTANCE;
	}
	
	private AbsLogger chainLogger() {
		
		AbsLogger infoLogger = new InfoLogger(LoggerLevel.INFO);
		AbsLogger debugLogger = new DebugLogger(LoggerLevel.DEBUG);
		infoLogger.setNextHandler(debugLogger);
		
		return infoLogger;
	}
	
	public void debug(final String message) {
		logger.logMessage(LoggerLevel.DEBUG, message);
	}
	
	public void info(final String message) {
		logger.logMessage(LoggerLevel.INFO, message);
	}
}
