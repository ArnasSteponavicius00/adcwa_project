package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerInterface;

@Service
public class CustomerService {
	@Autowired
	CustomerInterface ci;
	
	//Uses crud repo method to save customer to repo
	public void saveCustomer(Customer cust) {
		ci.save(cust);
	}
	
	//Uses interface crud to get all items found in customers table
	public ArrayList<Customer> getAllCustomers() {
		return (ArrayList<Customer>) ci.findAll();
	}
}
