package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.enums.CouponAvailable;

public abstract class AbsCoupon {
	
	private final int couponId;
	private final String couponDescription;
	private CouponAvailable couponAvailable;
	
	public AbsCoupon(final int couponId, final String couponDescription) {
		this.couponId = couponId;
		this.couponDescription = couponDescription;
		this.couponAvailable = CouponAvailable.YES; // coupon is available by default
	}
	
	public int getCouponId() {
		return couponId;
	}
	
	public String getCouponDescription() {
		return couponDescription;
	}
	
	public CouponAvailable getCouponAvailable() {
		return couponAvailable;
	}
	
	public void setCouponAvailable(final CouponAvailable couponAvailable) {
		this.couponAvailable = couponAvailable;
	}
	
	public abstract double priceAfterApplyingCoupon(double price);
}
