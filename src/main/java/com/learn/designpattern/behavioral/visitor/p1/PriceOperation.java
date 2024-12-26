package com.learn.designpattern.behavioral.visitor.p1;

public final class PriceOperation implements IHotelRoomOperation{
	
	@Override
	public void visit(final SingleRoom singleRoom) {
		singleRoom.setRoomPrice(1000);
	}
	
	@Override
	public void visit(final DoubleRoom doubleRoom) {
		doubleRoom.setRoomPrice(2000);
	}
	
	@Override
	public void visit(final PremiumRoom premiumRoom) {
		premiumRoom.setRoomPrice(4000);
	}
}
