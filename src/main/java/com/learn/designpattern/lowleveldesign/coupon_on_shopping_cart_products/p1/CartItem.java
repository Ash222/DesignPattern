package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

public record CartItem(Product product, int productQuantity) {
	
	public double totalPrice() {
		return product.price() * (double) productQuantity;
	}
}
