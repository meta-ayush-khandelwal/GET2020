package com.metacube.restAssignment;

import java.sql.SQLException;
import java.util.List;

public interface ItemEntity {

	public List<Item> getInventory() throws SQLException;
	
	public Item getItemByName(String itemName) throws SQLException;
	
	public List<Item> updateInventory(List<Item> newInventory) throws SQLException;

	public Item addItemToInventory(Item newItem) throws SQLException;
		
	public void deleteInventory() throws SQLException;

	public void deleteItemByName(String itemName) throws SQLException;

	public void updateInventoryItem(Item item)throws SQLException;

	
}
