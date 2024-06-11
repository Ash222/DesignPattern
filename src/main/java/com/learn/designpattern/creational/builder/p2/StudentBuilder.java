package com.learn.designpattern.creational.builder.p2;

public class StudentBuilder {

    private String name;
    private int age;
    private String address;

    private StudentBuilder() {
    }

    public static StudentBuilder builder() {

        return new StudentBuilder();
    }

    public String getAddress() {

        return address;
    }

    public StudentBuilder setAddress(String address) {

        this.address = address;
        return this;
    }

    public int getAge() {

        return age;
    }

    public StudentBuilder setAge(int age) {

        this.age = age;
        return this;
    }

    public String getName() {

        return name;
    }

    public StudentBuilder setName(String name) {

        this.name = name;
        return this;
    }

    public Student build() {

        return new Student(this);
    }
}
