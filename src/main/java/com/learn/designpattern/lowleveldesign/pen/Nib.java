package com.learn.designpattern.lowleveldesign.pen;

public class Nib {
	
	private final int radius;
	
	public Nib(final int radius) {
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
