package com.learn.designpattern.lowleveldesign.parkinglot.models;

public class Operator {
	
	private final int id;
	private final String name;
	
	public Operator(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
