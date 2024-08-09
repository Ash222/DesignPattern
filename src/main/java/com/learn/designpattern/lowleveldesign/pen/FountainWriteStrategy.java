package com.learn.designpattern.lowleveldesign.pen;

public class FountainWriteStrategy implements IWriteStrategy{
	@Override
	public void write() {
		System.out.println("Fountain writing");
	}
}
