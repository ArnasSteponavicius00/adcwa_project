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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
@SessionAttributes("product")
public class ProductController {
	@Autowired
	ProductService ps;
	
	@RequestMapping(value= "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model) {
		//Variables and objects
		Product prod = new Product();
			
		model.addAttribute("product", prod);
		return "addProduct";
	}
	
	@RequestMapping(value= "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		//Error handle
		if(result.hasErrors()) {
			return "addProduct";
		}
		
		//save the product to database
		ps.saveProduct(product);
		return "redirect:showProducts.html";
	}
	
	@RequestMapping(value= "/showProducts.html", method=RequestMethod.GET)
	public String productAddedGET(Model model) {
		//Get all the products to display on the page
		ArrayList<Product> products = ps.getAllProducts();
		
		model.addAttribute("products", products);
		return "showProducts";
	}
}
