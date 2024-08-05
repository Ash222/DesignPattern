package com.learn.designpattern.design.pen;

public class ButterFlowWriteStrategy implements IWriteStrategy{
	@Override
	public void write() {
		System.out.println("Butterflow writing");
	}
}
