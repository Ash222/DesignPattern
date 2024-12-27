package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

public class PercentageDiscount extends Coupon {
	
	private final int percentageDiscount;
	
	public PercentageDiscount(final String couponCode, final String couponDescription,
			final CouponAvailable couponAvailable, final int percentageDiscount) {
		super(couponCode, couponDescription, couponAvailable);
		this.percentageDiscount = percentageDiscount;
	}
	
	public int getPercentageDiscount() {
		return percentageDiscount;
	}
	
	@Override
	public double applyCoupon(final double price) {
		return switch (getCouponAvailable()) {
			case YES -> price * (1 - (double) percentageDiscount / 100);
			case NO -> price;
		};
	}
}
