package com.learn.designpattern.creational.builder.p3;

public class Person {

    private String name;
    private String address;
    private int phoneNumber;
    private int aadharNumber;
    private String gender;

    private Person() {
    }

    public Person(final PersonBuilderImpl personBuilder) {

        this.name = personBuilder.getName();
        this.address = personBuilder.getAddress();
        this.phoneNumber = personBuilder.getPhoneNumber();
        this.aadharNumber = personBuilder.getAadharNumber();
        this.gender = personBuilder.getGender();
    }

    @Override
    public String toString() {

        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", aadharNumber='").append(aadharNumber).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append('}');

        return sb.toString();
    }
}
