package com.learn.designpattern.creational.builder.p2;

public class Student {

    private String name;
    private int age;
    private String address;

    private Student() {
    }

    public Student(StudentBuilder studentBuilder) {

        this.name = studentBuilder.getName();
        this.age = studentBuilder.getAge();
        this.address = studentBuilder.getAddress();
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
