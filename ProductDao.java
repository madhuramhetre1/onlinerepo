package com.shopping.dao;

import java.util.List;

import com.shopping.model.Product;

public interface ProductDao {
	Product getProductDetails(Integer id);
	List<Product> listProducts();
}
