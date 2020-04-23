package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sales.models.Order;

@Controller
public class OrderController {
	@RequestMapping(value= "/addOrder.html")
	public String addOrder(Model model){
		Order order = new Order();
		model.addAttribute("product", order);
		
		return "addOrder";
	}
}
