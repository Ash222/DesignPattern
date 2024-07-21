package com.learn.designpattern.behavioral.chain_of_responsibility.p1;

public class InfoLogger extends AbsLogger {
    
    public InfoLogger(LoggerLevel loggerLevel) {
        
        super(loggerLevel);
    }
    
    @Override
    void displayMessage(String message) {

        System.out.println("INFO LOGGER ::: " + message);
    }
}
