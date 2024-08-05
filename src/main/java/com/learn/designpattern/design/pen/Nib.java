package com.learn.designpattern.design.pen;

public class Nib {
	
	private int radius;
	
	public Nib(int radius) {
		this.radius = radius;
	}
	
	public int getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Nib{");
		sb.append("radius=").append(radius);
		sb.append('}');
		return sb.toString();
	}
}
