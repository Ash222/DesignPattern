package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api.AbsCoupon;

public class PercentageAmountCoupon extends AbsCoupon {
	
	private final int discountPercentage;
	
	public PercentageAmountCoupon(final int couponId, final String couponDescription,
			final int discountPercentage) {
		super(couponId, couponDescription);
		this.discountPercentage = discountPercentage;
	}
	
	@Override
	public double priceAfterApplyingCoupon(final double price) {
		return switch (getCouponAvailable()) {
			case YES -> price * (1 - (double) discountPercentage / 100);
			case NO -> price;
		};
	}
}
