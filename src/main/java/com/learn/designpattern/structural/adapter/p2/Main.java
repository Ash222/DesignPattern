package com.learn.designpattern.structural.adapter.p2;

public class Main {
	
	public static void main(String[] args) {
		
		IShape shape = new LegacyRectangleAdapter();
		// IShape shape = new Rectangle();
		shape.draw(1, 2, 4, 6);
	}
}
