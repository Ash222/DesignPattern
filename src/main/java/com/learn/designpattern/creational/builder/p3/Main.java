package com.learn.designpattern.creational.builder.p3;

public class Main {

    public static void main(String[] args) {

        Person person = IPersonBuilder.builder().setName("Nagraj")
                .setAddress("Nagpur").setAadharNumber(1234).build();

        System.out.println("Main :: main :: person ::: " + person);
    }
}
