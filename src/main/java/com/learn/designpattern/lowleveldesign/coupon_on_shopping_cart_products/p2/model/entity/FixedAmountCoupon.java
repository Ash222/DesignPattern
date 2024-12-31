package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api.AbsCoupon;

public class FixedAmountCoupon extends AbsCoupon {
	
	private final int couponPrice;
	
	public FixedAmountCoupon(final int couponId, final String couponDescription,
			final int couponPrice) {
		super(couponId, couponDescription);
		this.couponPrice = couponPrice;
	}
	
	@Override
	public double priceAfterApplyingCoupon(final double price) {
		return switch (getCouponAvailable()) {
			case YES -> Math.max(0, price - couponPrice);
			case NO -> price;
		};
	}
}
