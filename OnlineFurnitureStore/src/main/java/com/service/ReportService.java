package com.service;

import java.util.List;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Order;

public interface ReportService {

	List<Bill> getAllBills();
	List<Customer> getAllCustomers();
	List<Cart> getAllCarts();
	List<Order> getAllOrders();
}
