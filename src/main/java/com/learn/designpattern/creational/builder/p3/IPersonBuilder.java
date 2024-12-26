package com.learn.designpattern.creational.builder.p3;

public interface IPersonBuilder {
	
	static IName builder() {
		return new PersonBuilderImpl();
	}
	
	sealed interface IName permits PersonBuilderImpl {
		IAddress setName(String name);
	}
	
	sealed interface IAddress permits PersonBuilderImpl {
		IAadhar setAddress(String address);
	}
	
	sealed interface IAadhar permits PersonBuilderImpl {
		IOptional setAadharNumber(int aadharNumber);
	}
	
	sealed interface IOptional permits PersonBuilderImpl {
		IOptional setPhoneNumber(int phoneNumber);
		IOptional setGender(String gender);
		Person build();
	}
}
