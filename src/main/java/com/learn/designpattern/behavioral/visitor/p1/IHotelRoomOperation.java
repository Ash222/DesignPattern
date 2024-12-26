package com.learn.designpattern.behavioral.visitor.p1;

public sealed interface IHotelRoomOperation
		permits PriceOperation, MaintenanceOperation {
	void visit(SingleRoom singleRoom);
	
	void visit(DoubleRoom doubleRoom);
	
	void visit(PremiumRoom premiumRoom);
}
