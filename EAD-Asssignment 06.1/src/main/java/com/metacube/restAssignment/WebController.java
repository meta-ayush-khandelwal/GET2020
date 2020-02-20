package com.metacube.restAssignment;

import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class WebController {

	private ItemEntity inventory = new ItemEntityImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> getInventory() throws SQLException {
		return inventory.getInventory();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{itemName}")
	public Item getInventoryItem(@PathParam("itemName") String itemName) throws SQLException {
		return inventory.getItemByName(itemName);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> updateInventory(List<Item> newInventory) throws SQLException {
		return inventory.updateInventory(newInventory);
	}
	
	@PUT
	@Path("/{itemName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateInventoryItem(Item item) throws SQLException {
		inventory.updateInventoryItem(item);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Item addItemToInventory(Item newItem) throws SQLException {
		return inventory.addItemToInventory(newItem);
	}

	@DELETE
	public void deleteInventory() throws SQLException {
		inventory.deleteInventory();
	}

	@DELETE
	@Path("/{itemName}")
	public void deleteItemFromInventory(@PathParam("itemName") String itemName) throws SQLException {
		inventory.deleteItemByName(itemName);
	}
}
