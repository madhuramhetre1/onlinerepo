package com.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.ProductDao;
import com.shopping.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao dao;

	@Override
	public Product getProductDetails(Integer id) {
		return dao.getProductDetails(id);
	}

	@Override
	@Transactional
	public List<Product> listProducts() {
		System.out.println("in b.l of service ");
		return dao.listProducts();
	}

}
