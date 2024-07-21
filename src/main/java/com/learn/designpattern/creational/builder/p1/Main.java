package com.learn.designpattern.creational.builder.p1;

public class Main {

    public static void main(String[] args) {

        Student student = Student.getBuilder().setName("Ashwini")
                .setAge(200).build();

        System.out.println(student);
    }
}
