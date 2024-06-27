package com.learn.designpattern.behavioral.mediator.p1;

public class Main {
	
	public static void main(String[] args) {
		
		AuctionMediator auctionMediator = new ToyAuction("ToyAuction");
		Bidder bidder1 = new Bidder("ash", auctionMediator);
		Bidder bidder2 = new Bidder("anu", auctionMediator);
		Bidder bidder3 = new Bidder("batman", auctionMediator);
		
		bidder2.placeBid(100);
		bidder1.placeBid(300);
	}
}
