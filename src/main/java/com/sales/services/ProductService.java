package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductInterface;

@Service
public class ProductService {
	@Autowired
	ProductInterface pi;
	
	//Save the product to the table via crud repo
	public void saveProduct(Product prod) {
		pi.save(prod);
	}
	
	//Uses interface crud to get all items found in products table
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) pi.findAll();
	}
}
