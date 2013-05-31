package com.bekkestad.examples.tutorial.service;

import java.util.List;

import com.bekkestad.examples.tutorial.model.ProductDAO;

public interface ShoppingCartService {

	void addProduct(ProductDAO product);

	void removeProduct(Long productId);

	List<ProductDAO> getShoppingCart();

	Long placeOrder() throws Exception;

	String getOrderStatus(Long orderId) throws Exception;

}