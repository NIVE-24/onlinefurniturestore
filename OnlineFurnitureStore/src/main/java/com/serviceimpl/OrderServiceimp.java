package com.serviceimpl;

import java.util.List;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.OrderRepository;
import com.service.OrderService;
import com.entity.Order;
import com.exception.UserNotFoundException;


/**
 * Author: Priyanka N 
 * Date:18-09-2021 
 * Description:This is OrderService Layer that provide service to view all furniture order,update funiture order
 **/
@Service
@Transactional

public class OrderServiceimp implements OrderService {

	Logger logger = Logger.getLogger(OrderServiceimp.class);
	@Autowired
	public OrderRepository od;

	/**
	 * Description : To fetch all FurnitureOrder details from the database 
	 * Return Value :List<FurnitureOrder> object of the furnitureOrder been fetched
	 *  Exception : UserNotFoundException - It is raised when FurnitureOrder is empty
	 * 
	 * @throws UserNotFoundException
	 **/
	@Override
	public List<Order> getAllOrders() {
		logger.info("Fetching FurnitureOrder inprogress...");
		List<Order> getFurniture = od.findAll();
		logger.info("Order details: " + getFurniture);
		return getFurniture;
	}


	/**

	*Description	:To update FurnitureOrde details to the database
	*Input Params	:FurnitureOrde to be updated in the database
	*Return Value	:FurnitureOrde object of the FurnitureOrde been updated
	*Exception	:UserNotFoundException-It is raised when FurnitureOrder is empty   
	*
	*
	 * @throws UserNotFoundException
	**/
	@Override
	public Order updateOrder(Order order) throws UserNotFoundException {
		if ((order != null)) {

			logger.info("Update Order inprogress...");
			Order updateUser = od.save(order);
			logger.info("Order details: " + updateUser);
			return updateUser;

		} else {
			throw new UserNotFoundException("Order no exist");

		}
	}

	/**

	*Description	:To update FurnitureOrde details to the database
	*Input Params	:FurnitureOrde to be updated in the database
	*Return Value	:FurnitureOrde object of the FurnitureOrde been updated
	*Exception	:UserNotFoundException-It is raised when FurnitureOrde doesn't exist   
	*
	*
	 * @throws UserNotFoundException
	**/
	@Override
	public Order updateOrderById(String orderId, Order order) throws UserNotFoundException {
		Order resultUser;
		try {
			logger.info("Update Order by ID inprogress...");
			order = od.findById(orderId).orElse(null);
			if (orderId.equals(order.getOrderId())) {
				resultUser = od.save(order);
				logger.info("Order details: " + resultUser);
				return resultUser;
			}

			else {
				throw new UserNotFoundException("No order found");
			}
		} catch (Exception e) {
			throw new UserNotFoundException("no orderFound");
		}
	}

}
