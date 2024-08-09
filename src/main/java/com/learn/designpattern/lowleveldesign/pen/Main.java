package com.learn.designpattern.lowleveldesign.pen;

public class Main {
	
	public static void main(String[] args) {
		
		IWriteStrategy writeStrategy = new FountainWriteStrategy();
		Pen fountainPen = new Pen("Hell", "NP", 100, writeStrategy);
		System.out.println("fountain pen :: " + fountainPen);
		fountainPen.write();
	}
}
