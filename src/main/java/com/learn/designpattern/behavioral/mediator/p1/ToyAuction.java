package com.learn.designpattern.behavioral.mediator.p1;

public class ToyAuction extends AuctionMediator {
	
	public ToyAuction(String auctionName) {
		super(auctionName);
	}
	
	@Override
	void placeBid(final int amount, final String bidderName) {
		System.out.println(bidderName + " has placed a bid of " + amount + " amount!");
		this.sendBiddingNotification(bidderName, amount);
	}
}
