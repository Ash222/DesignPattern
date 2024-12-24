package com.learn.designpattern.structural.adapter.p2;

public non-sealed class Rectangle implements IShape {
	@Override
	public void draw(int x, int y, int width, int height) {
		System.out.println("Drawing Rectangle at (" + x + ", " + y + ") with width "
				+ width +" and height " + height);
	}
}
