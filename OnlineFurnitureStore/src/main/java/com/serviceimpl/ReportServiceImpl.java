package com.serviceimpl;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Order;
import com.repository.BillRepository;
import com.repository.CartRepository;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.service.ReportService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportServiceImpl implements ReportService {
	
	Logger logger = Logger.getLogger(ReportServiceImpl.class);
	
    @Autowired
    BillRepository billRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Bill> getAllBills() {
    	logger.info("Fetching bills inprogress...");
    	List<Bill> bills = billRepository.findAll();
    	logger.info("Bills details: "+bills);
        return bills;
    }

    @Override
    public List<Customer> getAllCustomers() {
    	logger.info("Fetching customers inprogress...");
    	List<Customer> customers = customerRepository.findAll();
    	logger.info("Customers details: "+customers);
        return customers;
    }

    @Override
    public List<Cart> getAllCarts() {
    	logger.info("Fetching carts inprogress...");
    	List<Cart> carts = cartRepository.findAll();
    	logger.info("Carts details: "+carts);
        return carts;
    }

    @Override
    public List<Order> getAllOrders() {
    	logger.info("Fetching orders inprogress...");
    	List<Order> orders =  orderRepository.findAll();
    	logger.info("Orders details: "+orders);
        return orders;
    }
}
