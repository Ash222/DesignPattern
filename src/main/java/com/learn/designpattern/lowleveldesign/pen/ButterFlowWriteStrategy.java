package com.learn.designpattern.lowleveldesign.pen;

public class ButterFlowWriteStrategy implements IWriteStrategy{
	@Override
	public void write() {
		System.out.println("Butterflow writing");
	}
}
