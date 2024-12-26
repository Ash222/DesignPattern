package com.learn.designpattern.behavioral.visitor.p1;

public final class DoubleRoom extends HotelRoom {
	
	@Override
	public void accept(final IHotelRoomOperation visitor) {
		visitor.visit(this);
	}
}
