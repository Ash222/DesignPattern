package com.learn.designpattern.structural.adapter.p2;

// this is adaptee class
public class LegacyRectangle {
	
	public void drawRectangle(int x1, int y1, int x2, int y2) {
		System.out.println("Drawing LegacyRectangle with corners (" + x1 + ", " + y1 +
				") and (" + x2 + ", " + y2 + ")");
	}
}
