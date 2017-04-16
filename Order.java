package com.shopping.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="orders")

public class Order {

	private Integer orderId;
	private Integer total_price;
	private String shipping_address;
	private Date shipping_date;
	private List<Product> products;
	private User user;
	private Product product;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "orderid")
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Column(name = "totalprice")
	public Integer getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Integer total_price) {
		this.total_price = total_price;
	}
	
	@Column(name = "shipaddress")
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "shipdate")
	public Date getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}
	
	
	@OneToMany(targetEntity=Product.class,mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@Fetch(value=FetchMode.SUBSELECT)
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="productid")
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
}
