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
	
	public void saveProduct(Product prod) {
		pi.save(prod);
	}
	
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) pi.findAll();
	}
}
