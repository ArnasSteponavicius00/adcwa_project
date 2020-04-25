package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Customer;
import com.sales.services.CustomerService;


@Controller
@SessionAttributes("customer")
public class CustomerController {
	@Autowired
	CustomerService cs;
	
	@RequestMapping(value= "/addCustomer.html", method=RequestMethod.GET)
	public String addCustomerGET(Model model) {
		Customer cust = new Customer();
		model.addAttribute("customer", cust);
		
		return "addCustomer";
	}

	@RequestMapping(value= "/addCustomer.html", method=RequestMethod.POST)
	public String addCustomerPOST(@ModelAttribute("customer") Customer cust) {
		cs.saveCustomer(cust);
		return "redirect:showCustomers.html";
	}
	
	@RequestMapping(value= "/showCustomers.html", method=RequestMethod.GET)
	public String productAddedGET(Model model) {
		ArrayList<Customer> customer = cs.getAllCustomers();
		model.addAttribute("customers", customer);
		return "showCustomers";
	}
}
