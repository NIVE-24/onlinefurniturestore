package com.service;

import com.entity.Furniture;
import com.entity.Order;
import com.exception.OrderServiceException;

public interface OrderCancellationService {
	String deleteOrder() throws OrderServiceException;
	String deleteOrderById(String orderId) throws OrderServiceException;
}
