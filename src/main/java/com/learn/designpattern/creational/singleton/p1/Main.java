package com.learn.designpattern.creational.singleton.p1;

public class Main {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println("Main :: main :: singleton.hashCode ::: " + singleton);
        System.out.println("Main :: main :: singleton1.hashCode ::: " + singleton1);
    }
}
