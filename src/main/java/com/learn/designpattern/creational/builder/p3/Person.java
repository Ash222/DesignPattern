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
	    return "Person{" + "name='" + name + '\'' +
			    ", address='" + address + '\'' +
			    ", aadharNumber='" + aadharNumber + '\'' +
			    ", phoneNumber='" + phoneNumber + '\'' +
			    ", gender='" + gender + '\'' +
			    '}';
    }
}
