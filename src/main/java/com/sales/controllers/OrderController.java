package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("order")
public class OrderController {
	@Autowired
	OrderService os;
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	ProductService ps;
	
	@RequestMapping(value= "/newOrder.html", method=RequestMethod.GET)
	public String addOrderGET(Model model){
		// Variables
		Order order = new Order();	
		ArrayList<Customer> customers = cs.getAllCustomers();
		ArrayList<Product> products = ps.getAllProducts();
		Map<Long, String> customersList = new HashMap<Long, String>();
		Map<Long, String> productsList = new HashMap<Long, String>();
		String date = order.getOrderDate();
		
		// Get the list of customers and add them to the map
		for (Customer c : customers) {
			customersList.put(c.getcId(), c.getcName());
		}
		
		// Get the list of products and add them to the map
		for (Product p : products) {
			productsList.put(p.getpId(), p.getpDesc());
		}
		
		//Set date to current date
		order.setOrderDate(date);
		
		//add the attributes for use in jsp file
		model.addAttribute("customers", customersList);	
		model.addAttribute("products", productsList);
		model.addAttribute("order", order);
	
		return "newOrder";
	}
	
	@RequestMapping(value= "/newOrder.html", method=RequestMethod.POST)
	public String addOrderPOST(@Valid @ModelAttribute("order") Order order, BindingResult result, Product product, Model model) {
		
		if(result.hasErrors()) {
			return "newOrder";
		}
		
		// variables
		Product prod = new Product();
		Customer cust = new Customer();
		int prodQty;
		int orderQty;
		//Get the products from orders
		product = order.getProd();
		
		// Assign the quantities for products and orders
		prodQty = product.getQtyInStock();
		orderQty = order.getQty();
		
		if(prodQty <= orderQty) {
			//take them away everytime this methods is executed
			prodQty -= orderQty;
			
			// Set the stock quantity in the products object
			product.setQtyInStock(prodQty);
			
			os.saveOrder(order);
			return "redirect:showOrders.html";
		}
		else {
			//add the attributes for use in jsp file
			model.addAttribute("customers", cust);	
			model.addAttribute("products", prod);
			model.addAttribute("order", order);
			return "orderError";
		}
	}
	
	@RequestMapping(value= "/showOrders.html", method=RequestMethod.GET)
	public String orderAddedGET(Model model) {
		//get all the orders placed
		ArrayList<Order> orders = os.getAllOrders();
		
		model.addAttribute("orders", orders);
		return "showOrders";
	}
}
