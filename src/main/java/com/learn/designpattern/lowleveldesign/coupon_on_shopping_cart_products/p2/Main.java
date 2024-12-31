package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p2;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.controller.ShoppingCartController;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api.AbsCoupon;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.FixedAmountCoupon;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.PercentageAmountCoupon;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.Product;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.repository.ShoppingCartRepository;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.service.ShoppingCartService;

public class Main {
	
	public static void main(String[] args) {
		
		Product p1 = new Product(1, "t-shirt", 200);
		Product p2 = new Product(2, "jeans", 900);
		AbsCoupon c1 = new FixedAmountCoupon(1, "₹100 OFF",
		                                     100);
		AbsCoupon c2 = new PercentageAmountCoupon(2, "10% OFF",
		                                          10);
		
		double price = 0.0;
		final ShoppingCartController shoppingCartController =
				new ShoppingCartController(
						new ShoppingCartService(new ShoppingCartRepository())
				);
		
		shoppingCartController.addProduct(p1, 2);
		shoppingCartController.addProduct(p2, 3);
		// shoppingCartController.addCoupon(c1);
		// shoppingCartController.addCoupon(c2);
		price = shoppingCartController.getShoppingCartItemsPrice();
		System.out.println("total price ::: " + price);
	}
}
