package com.metacube.restAssignment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {
	
	String name;
	int quantity;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
