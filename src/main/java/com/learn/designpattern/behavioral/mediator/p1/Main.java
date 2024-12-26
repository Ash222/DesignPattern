package com.learn.designpattern.behavioral.mediator.p1;

public class Main {
	
	public static void main(String[] args) {
		
		AuctionMediator toyAuctionMediator = new ToyAuction("ToyAuction");
		Bidder bidder1 = new Bidder("ash", toyAuctionMediator);
		Bidder bidder2 = new Bidder("anu", toyAuctionMediator);
		Bidder bidder3 = new Bidder("batman", toyAuctionMediator);
		
		bidder2.placeBid(100);
		bidder1.placeBid(300);
	}
}
