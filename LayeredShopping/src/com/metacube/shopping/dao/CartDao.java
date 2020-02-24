package com.metacube.shopping.dao;

import java.util.HashMap;

import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

public class CartDao {

	static HashMap<Integer, Item> products = new HashMap<Integer,Item>();	

	static HashMap<Integer,Item> userCart =new HashMap<Integer,Item>(); 

	public static HashMap<Integer, Item> allAvailableItems(){
		Item prod1 = new Item("Candy",40);
		Item prod2 = new Item("Bread",30);
		Item prod3 = new Item("Butter",50);
		Item prod4 = new Item("Milk",43);
		Item prod5 = new Item("Toast",60);
		Item prod6 = new Item("Curd",20);
		Item prod7 = new Item("Cream",80);
		Item prod8 = new Item("Pastry",45);
		Item prod9 = new Item("Cake",300);
		Item prod10 = new Item("Panner",200);
		Item prod11 = new Item("Egg",8);
		products.put(1,prod1);
		products.put(2,prod2);
		products.put(3,prod3);
		products.put(4,prod4);
		products.put(5,prod5);
		products.put(6,prod6);
		products.put(7,prod7);
		products.put(8,prod8);
		products.put(9,prod9);
		products.put(10,prod10);
		products.put(11,prod11);
		return products;
	}

	public static void addItem(int id,int quantity){
		if(userCart.containsKey(id)){
			int newQuantity = userCart.get(id).getQuantity() + quantity;
			userCart.get(id).setQuantity(newQuantity);
			System.out.println(CartMessage.ALREADYADDED + newQuantity);
		}
		else{
			products.get(id).setQuantity(quantity);
			userCart.put(id,products.get(id));
			System.out.println(CartMessage.ITEMADDED);
		}
	}
	
	public static void editItem(int id,int quantity){
		if(!userCart.containsKey(id)){
			System.out.println(CartMessage.ITEMNOTINCART);
		}
		else{
			System.out.println(CartMessage.ITEMEDITED);
			userCart.get(id).setQuantity(quantity);
		}
	}
	
	public static void removeItem(int id){
		if(!userCart.containsKey(id)){
			System.out.println(CartMessage.INVALIDID);
		}
		else{
			userCart.remove(id);
			System.out.println(CartMessage.ITEMREMOVED);
		}
	}
	
	public static HashMap<Integer,Item> getUserCart(){
		return userCart;
	}
}
