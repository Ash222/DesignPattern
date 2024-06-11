package com.learn.designpattern.behavioral.chainofresponsibility.p1;

public class Main {

    public static void main(String[] args) {

        final AbsLogger logger = chainLogger();
        logger.logMessage(LoggerLevel.DEBUG,"data store");
        logger.logMessage(LoggerLevel.INFO,"data show");
    }

    private static AbsLogger chainLogger(){

        AbsLogger infoLogger = new InfoLogger(LoggerLevel.INFO);
        AbsLogger debugLogger = new DebugLogger(LoggerLevel.DEBUG);
        infoLogger.setNextHandler(debugLogger);

        return infoLogger;
    }
}
