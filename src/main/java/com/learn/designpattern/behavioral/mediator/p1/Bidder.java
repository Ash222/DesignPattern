package com.learn.designpattern.behavioral.mediator.p1;

public class Bidder {
	
	private final String bidderName;
	private final AuctionMediator auctionMediator;
	
	public Bidder(final String bidderName, final AuctionMediator auctionMediator) {
		
		this.bidderName = bidderName;
		this.auctionMediator = auctionMediator;
		this.auctionMediator.addBidder(this);
	}
	
	public String getBidderName() {
		return bidderName;
	}
	
	public void placeBid(final int amount) {
		this.auctionMediator.placeBid(amount, this.bidderName);
	}
	
	public void receiveBidNotification(final int amount) {
		System.out.println(
				"A bid of amount ::: " + amount + " has been placed just now!");
	}
}
