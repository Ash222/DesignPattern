package com.learn.designpattern.behavioral.chainofresponsibility.p1;

public class DebugLogger extends AbsLogger {

    public DebugLogger(final LoggerLevel loggerLevel) {

        this.loggerLevel = loggerLevel;
    }

    @Override
    void displayMessage(String message) {

        System.out.println("DEBUG LOGGER ::: " + message);
    }
}
