package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.repositories.OrderInterface;

@Service
public class OrderService {
	@Autowired
	OrderInterface oi;
	
	//Save the product to the table via crud repo
	public void saveOrder(Order order) {
		oi.save(order);
	}

	//Uses interface crud to get all items found in products table
	public ArrayList<Order> getAllOrders() {
		return (ArrayList<Order>) oi.findAll();
	}
	
	//Used to update quantities of products on initial startup
	public void updateQuantity() {
		oi.updateQuantity();
	}
}
