package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

public class FixedAmountDiscount extends Coupon {
	
	private final double discountAmount;
	
	public FixedAmountDiscount(final String couponCode, final String couponDescription,
			final CouponAvailable couponAvailable, final double discountAmount) {
		super(couponCode, couponDescription, couponAvailable);
		this.discountAmount = discountAmount;
	}
	
	public double getDiscountAmount() {
		return discountAmount;
	}
	
	@Override
	public double applyCoupon(final double price) {
		return switch (getCouponAvailable()) {
			case YES -> Math.max(0, price - discountAmount);
			case NO -> price;
		};
	}
}
