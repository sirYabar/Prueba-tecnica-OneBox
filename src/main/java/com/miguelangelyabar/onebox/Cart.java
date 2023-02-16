package com.miguelangelyabar.onebox;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	public static long TIME_TO_LIVE = 600000L;
	
	private List<Product> products;
	private long timeLastUpdate;
	
	public Cart() {
		this.products = new ArrayList<Product>();
		this.timeLastUpdate = System.currentTimeMillis();
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void addProduct(Product product) {
		if (!isExpired()) {
			this.products.add(product);
			timeLastUpdate = System.currentTimeMillis();
		}
		else {
			deleteCart();
		}
	}
	
	public void deleteCart() {
		this.products.clear();
	}
	
	public boolean isExpired() {
		return (System.currentTimeMillis() - timeLastUpdate) > TIME_TO_LIVE;
	}
}
