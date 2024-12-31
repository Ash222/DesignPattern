package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.controller;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api.AbsCoupon;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products.p2.model.dto.CartItem;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.Product;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.service.ShoppingCartService;

import java.util.List;

public class ShoppingCartController {
	
	private final ShoppingCartService shoppingCartService;
	
	public ShoppingCartController(final ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	
	public String addProduct(final Product product, final int productQuantity) {
		return shoppingCartService.addProduct(product,productQuantity);
	}
	
	public String addCoupon(final AbsCoupon coupon){
		return shoppingCartService.addCoupon(coupon);
	}
	
	public double getShoppingCartItemsPrice(){
		return shoppingCartService.getShoppingCartItemsPrice();
	}
	
	public List<AbsCoupon> getCouponList(){
		return shoppingCartService.getCouponList();
	}
	
	public List<CartItem> getCartItemList(){
		return shoppingCartService.getCartItemList();
	}
}
