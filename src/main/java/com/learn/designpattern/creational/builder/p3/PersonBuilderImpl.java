package com.learn.designpattern.creational.builder.p3;

public class PersonBuilderImpl implements IPersonBuilder.IName, IPersonBuilder.IAddress,
        IPersonBuilder.IAadhar, IPersonBuilder.IOptional {

    private String name;
    private String address;
    private int phoneNumber;
    private int aadharNumber;
    private String gender;

    public PersonBuilderImpl() {
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getAadharNumber() {
        return aadharNumber;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public IPersonBuilder.IAddress setName(String name) {

        this.name = name;
        return this;
    }

    @Override
    public IPersonBuilder.IAadhar setAddress(String address) {

        this.address = address;
        return this;
    }

    @Override
    public IPersonBuilder.IOptional setAadharNumber(int aadharNumber) {

        this.aadharNumber = aadharNumber;
        return this;
    }

    @Override
    public IPersonBuilder.IOptional setPhoneNumber(int phoneNumber) {

        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public IPersonBuilder.IOptional setGender(String gender) {

        this.gender = gender;
        return this;
    }

    @Override
    public Person build() {

        return new Person(this);
    }
}
