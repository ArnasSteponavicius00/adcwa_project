package com.sales.controllers;

import java.util.ArrayList;

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
import com.sales.services.CustomerService;

@Controller
@SessionAttributes("customer")
public class CustomerController {
	@Autowired
	CustomerService cs;

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.GET)
	public String addCustomerGET(Model model) {
		// Create customer object
		Customer cust = new Customer();
		
		model.addAttribute("customer", cust);
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer.html", method = RequestMethod.POST)
	public String addCustomerPOST(@Valid @ModelAttribute("customer") Customer cust, BindingResult result) {
		//Error handles
		if (result.hasErrors()) {
			return "addCustomer";
		}

		//save the customer to database
		cs.saveCustomer(cust);
		return "redirect:showCustomers.html";
	}

	@RequestMapping(value = "/showCustomers.html", method = RequestMethod.GET)
	public String productAddedGET(Model model) {
		//Get all customers in for display
		ArrayList<Customer> customer = cs.getAllCustomers();
		
		model.addAttribute("customers", customer);
		return "showCustomers";
	}
}
