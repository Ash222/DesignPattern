package com.learn.designpattern.structural.flyweight.p1;

public class Robot implements IRobotFlyWeight {
	
	private final String type;
	private final Look look;
	
	public Robot(String type, Look look) {
		this.type = type;
		this.look = look;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void display(final int x, final int y) {
		System.out.println("Coordinates ::: (" + x + "," + y + ") :: type ::: "
				                   + this.type);
	}
}
