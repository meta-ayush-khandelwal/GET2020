package com.metacube.shopping.controller;

import java.util.HashMap;

import com.metacube.shopping.facade.CartFacade;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

public class CartController {

	public static HashMap<Integer, Item> allAvailableItemsController(){
		HashMap<Integer, Item> products = CartFacade.allAvailableItemsFacade();
		return products;
	}

	public static void showItem(HashMap<Integer, Item> products){
		System.out.println(CartMessage.SHOPPINGHEADER);
		for (HashMap.Entry<Integer,Item> entry : products.entrySet()){
			System.out.println(entry.getKey() +" \t \t"+entry.getValue().getName()+" \t \t"+ entry.getValue().getPrice());
		}
	}

	public static void addItemController(int id,int quantity){
		CartFacade.addItemFacade(id, quantity);
	}
	
	public static void viewCartController(){
		CartFacade.viewCartFacade();
	}
	
	public static void editItemController(int id,int quantity){
		CartFacade.editItemFacade(id, quantity);
	}
	
	public static void removeItemController(int id){
		CartFacade.removeItemFacade(id);
	}
	
	public static int billController(){
		return CartFacade.billFacade();
	}
}
