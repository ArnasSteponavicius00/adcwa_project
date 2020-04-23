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
		System.out.println("Customer: "+ cust.getcId() + " " + cust.getcName());
		cs.saveCustomer(cust);
		return "redirect:customerAdded.html";
	}
	
	@RequestMapping(value= "/customerAdded.html", method=RequestMethod.GET)
	public String customerAddedGET(Model model) {
		ArrayList<Customer> customers = cs.getAllCustomers();
		model.addAttribute("costumer", customers);
		return "showCustomers";
	}
}
