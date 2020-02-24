package com.metacube.shopping.facade;

import java.util.HashMap;

import com.metacube.shopping.dao.CartDao;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

public class CartFacade {
	
	public static HashMap<Integer, Item> allAvailableItemsFacade(){
		HashMap<Integer, Item> products = CartDao.allAvailableItems();
		return products;
	}
	
	public static void addItemFacade(int id,int quantity){
		CartDao.addItem(id, quantity);
	}
	
	public static void viewCartFacade(){
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		if(userCart.isEmpty()){
			System.out.println(CartMessage.EMPTYCART);
		}
		else{
			System.out.println(CartMessage.CARTHEADER);
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())  
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity()); 
		}
	}
	
	public static void editItemFacade(int id,int quantity){
		CartDao.editItem(id, quantity);
	}
	
	public static void removeItemFacade(int id){
		CartDao.removeItem(id);
	}
	
	public static int billFacade(){
		HashMap<Integer,Item> userCart = CartDao.getUserCart();
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity() * entry.getValue().getPrice();
		return amount;
	}
}
