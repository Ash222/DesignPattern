package com.learn.designpattern.creational.singleton.p3;

public class Singleton {

    private Singleton(){}

    private static final class SingletonHolder{

        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){

        return SingletonHolder.INSTANCE;
    }
}
