package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public final class DebugLogger extends AbsLogger {
    
    public DebugLogger(LoggerLevel loggerLevel) {
        
        super(loggerLevel);
    }
    
    @Override
    void displayMessage(String message) {

        System.out.println("DEBUG LOGGER ::: " + message);
    }
}
