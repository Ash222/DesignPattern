package com.learn.designpattern.behavioral.chainofresponsibility.p1;

public class DebugLogger extends AbsLogger {
    
    public DebugLogger(LoggerLevel loggerLevel) {
        
        super(loggerLevel);
    }
    
    @Override
    void displayMessage(String message) {

        System.out.println("DEBUG LOGGER ::: " + message);
    }
}
