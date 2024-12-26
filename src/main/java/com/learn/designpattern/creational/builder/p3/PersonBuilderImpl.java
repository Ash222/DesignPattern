package com.learn.designpattern.creational.builder.p3;

public final class PersonBuilderImpl implements
		IPersonBuilder.IName,
		IPersonBuilder.IAddress,
		IPersonBuilder.IAadhar,
		IPersonBuilder.IOptional {
	
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
	public IPersonBuilder.IAddress setName(final String name) {
		this.name = name;
		return this;
	}
	
	@Override
	public IPersonBuilder.IAadhar setAddress(final String address) {
		this.address = address;
		return this;
	}
	
	@Override
	public IPersonBuilder.IOptional setAadharNumber(final int aadharNumber) {
		this.aadharNumber = aadharNumber;
		return this;
	}
	
	@Override
	public IPersonBuilder.IOptional setPhoneNumber(final int phoneNumber) {
		this.phoneNumber = phoneNumber;
		return this;
	}
	
	@Override
	public IPersonBuilder.IOptional setGender(final String gender) {
		this.gender = gender;
		return this;
	}
	
	@Override
	public Person build() {
		return new Person(this);
	}
}
