package com.learn.designpattern.behavioral.visitor.p1;

/*
 * Use case :
 * Use this pattern only when you want to decouple the number of operations from the class.
 * In case of increasing the operation then we just need to create new class for it,
 * thus it will increase horizontally.
 * The only downside is maintenance of the code base. Suppose, if tomorrow a new type of
 *  hotel room gets added, then we need to change the IHotelRoomOperation and respective
 *  places as well, which will add the maintenance overhead.
 *  */
public class Main {
	
	public static void main(String[] args) {
		
		HotelRoom singleRoom = new SingleRoom();
		HotelRoom doubleRoom = new DoubleRoom();
		HotelRoom premiumRoom = new PremiumRoom();
		IHotelRoomOperation priceOperation = new PriceOperation();
		singleRoom.accept(priceOperation);
		doubleRoom.accept(priceOperation);
		premiumRoom.accept(priceOperation);
		
		System.out.println("Single Room price ::: " + singleRoom.getRoomPrice());
		System.out.println("Double Room price ::: " + doubleRoom.getRoomPrice());
		System.out.println("Premium Room price ::: " + premiumRoom.getRoomPrice());
	}
}
