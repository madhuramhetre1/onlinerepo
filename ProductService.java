package com.shopping.service;

import java.util.List;

import com.shopping.model.Product;

public interface ProductService {

	Product getProductDetails(Integer id);
	List<Product> listProducts();
}
