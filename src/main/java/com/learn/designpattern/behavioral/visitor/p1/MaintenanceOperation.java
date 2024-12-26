package com.learn.designpattern.behavioral.visitor.p1;

public final class MaintenanceOperation implements IHotelRoomOperation {
	
	@Override
	public void visit(final SingleRoom singleRoom) {
		System.out.println("single room maintenance");
	}
	
	@Override
	public void visit(final DoubleRoom doubleRoom) {
		System.out.println("single room maintenance");
	}
	
	@Override
	public void visit(final PremiumRoom premiumRoom) {
		System.out.println("single room maintenance");
	}
}
