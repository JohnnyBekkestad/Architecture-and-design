package com.bekkestad.examples.tutorial.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import com.bekkestad.examples.tutorial.model.ProductDAO;
import com.bekkestad.examples.tutorial.repository.OrderRepository;

@SessionScoped
public class ShoppingCartServiceImpl implements Serializable, ShoppingCartService {

	private static final long serialVersionUID = 1L;
	private Map<Long, ProductDAO> shoppingCartMap;
	
	@EJB
	private OrderRepository order;

	@Override
	public void addProduct(ProductDAO product){
		shoppingCartMap.put(product.getId(), product);		
	}
	
	@Override
	public void removeProduct(Long productId){
		shoppingCartMap.remove(productId);
	}
	
	@Override
	public List<ProductDAO> getShoppingCart(){		
		return Collections.unmodifiableList(new ArrayList<ProductDAO>(shoppingCartMap.values()));			
	}
	
	@Override
	public Long placeOrder() throws Exception{
		Long orderId = order.placeOrder(getShoppingCart());
		shoppingCartMap.clear();
		return orderId;			
	}
	
	@Override
	public String getOrderStatus(Long orderId) throws Exception{
		return order.getOrder(orderId).getStatus();
	}
	
	@PostConstruct
	void initialize(){
		shoppingCartMap = new HashMap<Long, ProductDAO>();
	}
}
