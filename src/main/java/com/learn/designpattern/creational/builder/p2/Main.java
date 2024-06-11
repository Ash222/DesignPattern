package com.learn.designpattern.creational.builder.p2;

public class Main {

    public static void main(String[] args) {

        Student student = StudentBuilder.builder()
                .setName("Batman").setAge(300).build();

        System.out.println("Main :: main :: student ::: " + student);
    }
}
