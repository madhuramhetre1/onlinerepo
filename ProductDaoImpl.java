package com.shopping.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	private SessionFactory sf;
	
	@Override
	public Product getProductDetails(Integer id) {
		return (Product) sf.getCurrentSession().get(Product.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProducts() {
		return sf.getCurrentSession().createQuery("select p from Product p")
				.list();
	}

}
