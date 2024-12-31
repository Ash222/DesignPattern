package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.service;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.api.AbsCoupon;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.dto.CartItem;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.Product;
import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.repository.ShoppingCartRepository;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartService {
	
	private final ShoppingCartRepository shoppingCartRepository;
	private final List<CartItem> cartItemList;
	private final List<AbsCoupon> couponList;
	
	public ShoppingCartService(final ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.couponList = new ArrayList<>();
		this.cartItemList = new ArrayList<>();
	}
	
	public List<AbsCoupon> getCouponList() {
		return new ArrayList<>(couponList);
	}
	
	public List<CartItem> getCartItemList() {
		return new ArrayList<>(cartItemList);
	}
	
	// this method will be called before the system get logged off or user log-out.
	public void preDestroy() {
		
		// we will be saving only the cartItemList in the db, since the coupon can be
		// applied later as well.
		final String result = shoppingCartRepository.saveCartItemList(cartItemList);
		System.out.println("Saving the cart items ::: " + result);
	}
	
	public String addProduct(final Product product, final int productQuantity) {
		cartItemList.add(new CartItem(product, productQuantity));
		return "SUCCESS";
	}
	
	public String addCoupon(final AbsCoupon coupon) {
		couponList.add(coupon);
		return "SUCCESS";
	}
	
	public double getShoppingCartItemsPrice() {
		
		double totalPriceOfProduct = 0;
		
		// calculating the price
		for (final CartItem cartItem : cartItemList) {
			totalPriceOfProduct = totalPriceOfProduct + (cartItem.product().price() *
					cartItem.productQuantity());
		}
		
		// applying the discount
		for (final AbsCoupon coupon : couponList) {
			totalPriceOfProduct = coupon.priceAfterApplyingCoupon(totalPriceOfProduct);
		}
		
		return totalPriceOfProduct;
	}
}
