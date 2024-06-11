package com.learn.designpattern.creational.prototype.p1;

public class Main {

    public static void main(String[] args) {

        Student student = new Student("Batman", 1, 12);
        Student student1 = student.getClone();

        System.out.println("Main :: main :: student ::: " + student + " :: student" +
                ".hashCode ::: " + student.hashCode());
        System.out.println("Main :: main :: student1 ::: " + student1 + " :: student1" +
                ".hashCode ::: " + student1.hashCode());
    }
}
