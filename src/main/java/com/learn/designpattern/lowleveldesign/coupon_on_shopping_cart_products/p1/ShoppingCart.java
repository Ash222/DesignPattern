package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	
	private final List<CartItem> cartItemList;
	private final List<Coupon> couponList;
	
	public ShoppingCart() {
		this.cartItemList = new ArrayList<>();
		this.couponList = new ArrayList<>();
	}
	
	public List<CartItem> getCartItemList() {
		return new ArrayList<>(cartItemList);
	}
	
	public List<Coupon> getCouponList() {
		return new ArrayList<>(couponList);
	}
	
	public void addProduct(final Product product, final int productQuantity) {
		cartItemList.add(new CartItem(product, productQuantity));
	}
	
	public void addCoupon(final Coupon coupon) {
		couponList.add(coupon);
	}
	
	public double calculatePrice() {
		
		double totalPrice = 0;
		
		for (final CartItem cartItem : cartItemList) {
			totalPrice = totalPrice + cartItem.totalPrice();
		}
		
		for (final Coupon coupon : couponList) {
			totalPrice = coupon.applyCoupon(totalPrice);
		}
		
		return totalPrice;
	}
}
