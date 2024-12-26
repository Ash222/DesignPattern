package com.learn.designpattern.creational.builder.p3;

public class Main {
	
	public static void main(String[] args) {
		
		Person person = IPersonBuilder.builder()
		                              .setName("Ashwini Kumar")
		                              .setAddress("Bangalore")
		                              .setAadharNumber(123423423)
		                              .build();
		
		System.out.println("Main :: main :: person ::: " + person);
	}
}
