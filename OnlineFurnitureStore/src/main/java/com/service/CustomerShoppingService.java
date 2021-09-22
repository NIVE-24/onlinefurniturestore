package com.service;

import java.util.List;

import com.entity.Cart;
import com.entity.Furniture;
import com.entity.Order;
import com.exception.CustomerShoppingException;

public interface CustomerShoppingService {
	List<Furniture> getAllFurnitures() throws CustomerShoppingException;
	Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException;

	Cart addtoCart(Cart cart) throws CustomerShoppingException;
	
	Order placeOrder(Order order) throws CustomerShoppingException;

}
