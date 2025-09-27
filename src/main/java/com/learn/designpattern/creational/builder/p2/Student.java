package com.learn.designpattern.creational.builder.p2;

public final class Student {
	
	private String name;
	private int age;
	private String address;
	
	private Student() {
	}
	
	public Student(final StudentBuilder studentBuilder) {
		this.name = studentBuilder.getName();
		this.age = studentBuilder.getAge();
		this.address = studentBuilder.getAddress();
	}
	
	public static StudentBuilder builder() {
		return new StudentBuilder();
	}
	
	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' +
				", age=" + age + '\'' +
				", address='" + address + '\'' +
				'}';
	}
}
