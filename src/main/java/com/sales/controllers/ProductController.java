package com.sales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sales.models.Product;

@Controller
@SessionAttributes("product")
public class ProductController {
	
	@RequestMapping(value= "/addProduct.html", method=RequestMethod.GET)
	public String addProductGET(Model model){
		Product prod = new Product();
		model.addAttribute("product", prod);
		
		return "addProduct";
	}
	
	@RequestMapping(value= "/addProduct.html", method=RequestMethod.POST)
	public String addProductPOST(@ModelAttribute("product") Product product){
		System.out.println("Product: "+ product.getpId() + " " + product.getpDesc() + " " +  product.getQtyInStock());
		return "redirect:productAdded.html";
	}
	
	@RequestMapping(value= "/productAdded.html", method=RequestMethod.GET)
	public String productAddedGET(@ModelAttribute("product") Product product){
		
		return "showProducts";
	}
}
