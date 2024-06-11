package com.learn.designpattern.behavioral.chainofresponsibility.p1;

public class InfoLogger extends AbsLogger {

    public InfoLogger(final LoggerLevel loggerLevel) {

        this.loggerLevel = loggerLevel;
    }

    @Override
    void displayMessage(String message) {

        System.out.println("INFO LOGGER ::: " + message);
    }
}
