package com.metacube.shopping.validation;

import com.metacube.shopping.message.CartMessage;

public class CartValidation {

	public static int quantityValidation(int quantity){
		if(quantity > 10){
			quantity = 10;
			System.out.println(CartMessage.QUANTITYGREATERALERT);
			return quantity;
		}
		else
			return quantity;
	}
}
