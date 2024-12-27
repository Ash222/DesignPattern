package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p1;

public class Main {
	
	public static void main(String[] args) {
		
		Product p1 = new Product(1, "t-shirt", 200);
		Product p2 = new Product(2, "jeans", 900);
		Coupon c1 = new FixedAmountDiscount("FIXED100", "₹100 OFF",
		                                    CouponAvailable.YES, 100);
		Coupon c2 = new PercentageDiscount("SAVE10%", "10% OFF",
		                                   CouponAvailable.YES, 10);
		final ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addProduct(p1, 2);
		shoppingCart.addProduct(p2, 3);
		shoppingCart.addCoupon(c1);
		shoppingCart.addCoupon(c2);
		final double totalPrice = shoppingCart.calculatePrice();
		
		System.out.println("price ::: " + totalPrice);
	}
}
