package com.metacube.restAssignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ItemEntityImpl implements ItemEntity {

	Connection con = DbConnection.getConnection();

	public List<Item> getInventory() throws SQLException {
		Statement statement = con.createStatement();
		String query = "Select * from fruits";

		ResultSet resultSet = statement.executeQuery(query);

		List<Item> inventory = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item();
			item.setName(resultSet.getString(1));
			item.setQuantity(resultSet.getInt(2));
			inventory.add(item);

		}

		return inventory;
	}

	public Item getItemByName(String itemName) throws SQLException {
		Statement statement = con.createStatement();
		String query = "Select * from fruits where name = '" + itemName + "'";
		ResultSet resultSet = statement.executeQuery(query);

		Item item = new Item();
		while (resultSet.next()) {
			//item = new Item();
			item.setName(resultSet.getString(1));
			item.setQuantity(resultSet.getInt(2));
		}

		return item;

	}

	public List<Item> updateInventory(List<Item> newInventory) throws SQLException {
		deleteInventory();
		for (Item item : newInventory) {
			addItemToInventory(item);
		}
		return newInventory;
	}

	public Item addItemToInventory(Item newItem) throws SQLException {
		
		PreparedStatement preparedStatement = con.prepareStatement("insert into fruits values(?,?)");
		preparedStatement.setString(1, newItem.getName());
		preparedStatement.setInt(2, newItem.getQuantity());

		if (preparedStatement.executeUpdate() > 0) {
			return newItem;
		}
		return newItem;
	}

	public void deleteInventory() throws SQLException {
		Statement statement = con.createStatement();
		String query = "truncate table fruits";
		statement.execute(query);

	}

	public void deleteItemByName(String itemName) throws SQLException {
		Statement statement = con.createStatement();
		String query = "delete from fruits where name = '" + itemName + "'";
		statement.execute(query);

	}

	@Override
	public void updateInventoryItem(Item item) throws SQLException {
		String sql="update fruits set quantity=? where name=?";
		PreparedStatement stmt=con.prepareStatement(sql);
		
		stmt.setInt(1, item.getQuantity());
		stmt.setString(2, item.getName());
		stmt.executeUpdate();
		
	}
}
