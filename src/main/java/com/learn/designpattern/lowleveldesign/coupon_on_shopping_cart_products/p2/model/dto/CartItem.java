package com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.dto;

import com.learn.designpattern.lowleveldesign.coupon_on_shopping_cart_products
		.p2.model.entity.Product;

public record CartItem(Product product, int productQuantity) {
}
