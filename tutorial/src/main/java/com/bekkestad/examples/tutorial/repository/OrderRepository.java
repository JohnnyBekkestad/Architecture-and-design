package com.bekkestad.examples.tutorial.repository;

import java.util.List;

import javax.ejb.Local;

import com.bekkestad.examples.tutorial.model.OrderDAO;
import com.bekkestad.examples.tutorial.model.ProductDAO;

@Local
public interface OrderRepository {

	Long placeOrder(List<ProductDAO> order);	
	OrderDAO getOrder(Long orderId);	
}
