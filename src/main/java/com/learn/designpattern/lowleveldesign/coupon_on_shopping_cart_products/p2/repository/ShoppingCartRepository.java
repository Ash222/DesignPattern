package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.repository;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p2.model.dto.CartItem;

import java.util.List;

public class ShoppingCartRepository {
	
	// Assume that in this method we're making the db call and saving the cart items
	// in it and sending the "SUCCESS" message.
	public String saveCartItemList(final List<CartItem> cartItemList) {
		return "SUCCESS";
	}
}
