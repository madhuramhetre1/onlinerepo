package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	public ProductController(){
		System.out.println("in constr of " + getClass().getName());
	}

	
	@RequestMapping("/productlist1")
	public String showProducts(Model map) {
		System.out.println("in list products...");
		map.addAttribute("product_list", service.listProducts());
		return "ProductList";
	}
}
