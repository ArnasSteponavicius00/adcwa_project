package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		Order order = new Order();	
		ArrayList<Customer> customers = cs.getAllCustomers();
		ArrayList<Product> products = ps.getAllProducts();
		Map<Long, String> customersList = new HashMap<Long, String>();
		Map<Long, String> productsList = new HashMap<Long, String>();
		
		for (Customer c : customers) {
			customersList.put(c.getcId(), c.getcName());
		}
		
		for (Product p : products) {
			productsList.put(p.getpId(), p.getpDesc());
		}
		
		model.addAttribute("customers", customersList);	
		model.addAttribute("products", productsList);
		model.addAttribute("order", order);
	
		return "newOrder";
	}
	
	@RequestMapping(value= "/newOrder.html", method=RequestMethod.POST)
	public String addOrderPOST(@ModelAttribute("order") Order order) {
		os.saveOrder(order);
		return "redirect:showOrders.html";
	}
	
	@RequestMapping(value= "/showOrders.html", method=RequestMethod.GET)
	public String orderAddedGET(Model model) {
		ArrayList<Order> orders = os.getAllOrders();
		model.addAttribute("orders", orders);
		return "showOrders";
	}
}
