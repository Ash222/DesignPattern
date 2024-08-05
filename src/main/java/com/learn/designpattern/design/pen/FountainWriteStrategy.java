package com.learn.designpattern.design.pen;

public class FountainWriteStrategy implements IWriteStrategy{
	@Override
	public void write() {
		System.out.println("Fountain writing");
	}
}
