package com.metacube.shopping.client;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.metacube.shopping.controller.CartController;
import com.metacube.shopping.message.CartMessage;
import com.metacube.shopping.model.Item;

public class Client {
	static Scanner scanner = new Scanner(System.in);
	static int itemId = 0, itemQuantity = 0, option, amount, flag = 0;
	final static int ADDITEM = 1, VIEWCART = 2, EDITCART = 3, REMOVEITEM = 4, BILL = 5, EXIT = 6;

	public static void userInput(){
		do {
			System.out.println(CartMessage.OPTIONHEADER);
			System.out.println(CartMessage.SELECTOPTION);
			try {
				option = scanner.nextInt();
				switch(option){
				case ADDITEM:
					do{
						try{
							System.out.println(CartMessage.ENTERID);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size()){
								System.out.println(CartMessage.INVALIDID);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALIDID);
							System.out.println("");
						}
						scanner.nextLine();
					}while(flag == 0);
					do{
						try{
							System.out.println(CartMessage.ENTERQUANTITY);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0){
								System.out.println(CartMessage.QUANTITYINVALID);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.QUANTITYINVALID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.addItemController(itemId, itemQuantity);
					break;
				case VIEWCART:
					CartController.viewCartController();
					break;
				case EDITCART:
					do{
						try{
							System.out.println(CartMessage.ENTERIDEDIT);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size()){
								System.out.println(CartMessage.INVALIDID);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALIDID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					do{
						try{
							System.out.println(CartMessage.ENTERQUANTITY);
							itemQuantity = scanner.nextInt();
							if(itemQuantity <= 0){
								System.out.println(CartMessage.QUANTITYINVALID);
							}
							else
								flag = 0;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.QUANTITYINVALID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 1);
					CartController.editItemController(itemId,itemQuantity);
					break;
				case REMOVEITEM:
					do{
						try{
							System.out.println(CartMessage.ENTERIDREMOVE);
							itemId = scanner.nextInt();
							if(itemId <= 0 || itemId > CartController.allAvailableItemsController().size()){
								System.out.println(CartMessage.INVALIDID);
							}
							else
								flag = 1;
						}
						catch (InputMismatchException e) {
							System.out.print(CartMessage.INVALIDID);
							System.out.println();
						}
						scanner.nextLine();
					}while(flag == 0);
					CartController.removeItemController(itemId);
					break;
				case BILL:
					amount = CartController.billController();
					if(amount == 0)
						System.out.println(CartMessage.EMPTYCART);
					else
						System.out.println("The total amount is :" + amount);
					break;
				case EXIT:
					System.out.println(CartMessage.THANKYOU);
					System.exit(0);
					break;
				default:
					System.out.println(CartMessage.INVALIDOPTION);
				}
			} catch (Exception e) {
				System.out.println(CartMessage.INVALIDOPTION);
				scanner.nextLine();
			}
		}while(true);	
	}

	public static void main(String args[]){
		HashMap<Integer, Item> products = CartController.allAvailableItemsController();
		CartController.showItem(products);
		userInput();
	}
}
