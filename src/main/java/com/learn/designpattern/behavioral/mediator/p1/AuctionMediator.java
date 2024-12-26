package com.learn.designpattern.behavioral.mediator.p1;

import java.util.ArrayList;
import java.util.List;

public abstract class AuctionMediator {
	
	protected final String auctionName;
	protected final List<Bidder> bidderList;
	
	public AuctionMediator(final String auctionName) {
		this.auctionName = auctionName;
		this.bidderList = new ArrayList<>();
	}
	
	protected void addBidder(final Bidder bidder) {
		this.bidderList.add(bidder);
	}
	
	protected void sendBiddingNotification(final String bidderName, final int amount) {
		
		for (final Bidder bidder : this.bidderList) {
			
			if (!bidder.getBidderName().equalsIgnoreCase(bidderName)) {
				bidder.receiveBidNotification(amount);
			}
		}
	}
	
	abstract void placeBid(int amount, String bidderName);
}
