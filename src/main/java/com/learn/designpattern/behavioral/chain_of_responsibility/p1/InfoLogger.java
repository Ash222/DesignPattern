package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public final class InfoLogger extends AbsLogger {
    
    public InfoLogger(final LoggerLevel loggerLevel) {
        super(loggerLevel);
    }
    
    @Override
    public void displayMessage(final String message) {
        System.out.println("INFO ::: " + message);
    }
}
