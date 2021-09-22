package com.service;

import java.util.List;

import com.entity.Order;
import com.exception.UserNotFoundException;

public interface OrderService {

	List<Order> getAllOrders() throws UserNotFoundException;
	Order updateOrder(Order order) throws UserNotFoundException;
	Order updateOrderById(String orderId,Order order) throws UserNotFoundException;
}
