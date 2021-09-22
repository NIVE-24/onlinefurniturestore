package com.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.IOrderCancellation;
import com.service.OrderCancellationService;
import com.entity.Order;
import com.exception.OrderServiceException;

/**
 * Author: Divya lakshmi R
 *  Date:18-09-2021 
 *  Description:This is OrderCancellation Service Layer that provides service to order
 **/
@Service
@Transactional
public class OrderCancellationServiceimp implements OrderCancellationService {

	Logger logger = Logger.getLogger(OrderCancellationServiceimp.class);
	@Autowired
	IOrderCancellation orderRepo;

	/**
	*Description	:To delete all FurnitureOrder from the database
	*Input Params	:FurnitureOrder  to be deleted from the database
	*Return Value	:String 
	*Exception	:OrderServiceException-It is raised when there is no value in the furnitureorder 
	*
	* throws OrderServiceException
	**/
	@Override
	public String deleteOrder() throws OrderServiceException {
		logger.info("Fetching Furniture Order inprogress...");
		List<Order> resultFurniture;
		try {
			resultFurniture = orderRepo.findAll();
			if (resultFurniture != null) {
				orderRepo.deleteAll();
				logger.info("All Values are deleted successfully");
				return "All Values are deleted successfully";
			} else {
				throw new OrderServiceException("There is no value in the furniture");
			}
		} catch (Exception e) {
			throw new OrderServiceException("There is no value in the furniture");
		}

	}

	/**
	*Description	:To delete FurnitureOrder from the database
	*Input Params	:FurnitureOrder id to be deleted from the database
	*Return Value	:String
	*Exception	:OrderServiceException-It is raised when FurnitureOrder ID doesn't exist 
	*
	*  throws OrderServiceException
	**/
	@Override
	public String deleteOrderById(String orderId) throws OrderServiceException {
		try {
			logger.info("Deleteing Furniture Order inprogress...");
			Optional<Order> del = orderRepo.findById(orderId);
			if (del == null) {
				throw new OrderServiceException("no user found");
			} else {
				orderRepo.deleteById(orderId);
				logger.info("Order" + orderId);
				return "Order Deleted" + del;

			}
		} catch (Exception e) {
			throw new OrderServiceException("No order found");
		}
	}

}
