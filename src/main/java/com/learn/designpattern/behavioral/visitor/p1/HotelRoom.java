package com.learn.designpattern.behavioral.visitor.p1;

public sealed abstract class HotelRoom permits SingleRoom, DoubleRoom, PremiumRoom {
	
	private int roomPrice;
	
	protected int getRoomPrice() {
		return roomPrice;
	}
	
	protected void setRoomPrice(final int roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	abstract void accept(IHotelRoomOperation visitor);
}
