package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

public abstract class Coupon {
	
	private final String couponCode;
	private final String couponDescription;
	private final CouponAvailable couponAvailable;
	
	public Coupon(final String couponCode, final String couponDescription,
			final CouponAvailable couponAvailable) {
		this.couponCode = couponCode;
		this.couponDescription = couponDescription;
		this.couponAvailable = couponAvailable;
	}
	
	public String getCouponCode() {
		return couponCode;
	}
	
	public String getCouponDescription() {
		return couponDescription;
	}
	
	public CouponAvailable getCouponAvailable() {
		return couponAvailable;
	}
	
	abstract double applyCoupon(double price);
}
