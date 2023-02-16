package com.miguelangelyabar.onebox;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> products;
	
	public Cart() {
		this.products = new ArrayList<Product>();
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public void deleteCart() {
		this.products.clear();
	}
}
