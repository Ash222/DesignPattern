package com.learn.designpattern.creational.singleton.p2;

public final class Singleton {

    private static volatile Singleton INSTANCE;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (INSTANCE == null) {

            synchronized (Singleton.class) {

                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}