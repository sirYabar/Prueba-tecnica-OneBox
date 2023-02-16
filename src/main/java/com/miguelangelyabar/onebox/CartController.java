package com.miguelangelyabar.onebox;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {
	private Map<String,Cart> carts = new HashMap<String,Cart>();
	
	@PostMapping("/createCart")
	public void createCart() {
		String cartID = UUID.randomUUID().toString();
		Cart newCart = new Cart();
		
		carts.put(cartID, newCart);
	}
	
	@GetMapping("/getCartInfo/{id}")
	public Cart getCartInformation(@PathVariable String id) {
		Cart cart = carts.get(id);
		
		if (cart != null) {
			if (!cart.isExpired()) {
				return cart;
			}
			else {
				deleteCart(id);
			}
		}
		
		return null;
	}
	
	@GetMapping
	public Map<String,Cart> getAllCartsInfo() {
		return carts;
	}
	
	@PostMapping("/addProducts/{idCart}")
	public void addProductToCart(@PathVariable String idCart, @RequestBody Product product) {
		Cart cart = carts.get(idCart);
		
		if (cart != null) {
			cart.addProduct(product);
		}
	}
	
	@DeleteMapping("/deleteCart/{id}")
	public void deleteCart(@PathVariable String id) {
		carts.get(id).deleteCart();
		carts.remove(id);
	}
}
