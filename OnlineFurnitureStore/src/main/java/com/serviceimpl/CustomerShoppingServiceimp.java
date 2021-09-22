package com.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.IFurnitureRepositoryDAO;
import com.repository.CartRepository;
import com.repository.OrderRepository;
import com.service.CustomerShoppingService;
import com.entity.Cart;
import com.entity.Furniture;
import com.entity.Order;
import com.exception.CustomerShoppingException;
import com.exception.FurnitureServiceException;

/**
 * Author: JESLIN ANNA JACOB 
 * Date:19-09-2021 
 * Description:This is Customer Shopping Service Layer which provides view furniture, add to cart, place order
 **/
@Service
@Transactional
public class CustomerShoppingServiceimp implements CustomerShoppingService {

	Logger logger = Logger.getLogger(CustomerShoppingServiceimp.class);
	@Autowired
	private IFurnitureRepositoryDAO furnitureRepo;
	@Autowired
	CartRepository cartRepo;
	@Autowired
	public OrderRepository orderRepo;

	/**
	 * Description : To fetch all Furniture details from the database 
	 * Return Value :List<Furniture> object of the furniture been fetched
	 *  Exception : FurnitureServiceException - It is raised when Furniture is empty
	 * 
	 * @throws FurnitureServiceException
	 **/
	@Override
	public List<Furniture> getAllFurnitures() throws CustomerShoppingException{
		try {
		logger.info("Fetching Furnitures inprogress...");
		List<Furniture> resultFurniture = furnitureRepo.findAll();
		if(resultFurniture!=null) {
		logger.info("Furniture details: " + resultFurniture);
		return resultFurniture;
		}
		else {
			throw new CustomerShoppingException("The Furniture is empty");
		}
		}
		catch(Exception e) {
			throw new CustomerShoppingException("The Furniture is empty");
		}
	}

	/**
	 * Description : To fetch Furniture by name details from the database 
	 * Return Value :Furniture object of the furniture been fetched
	 *  Exception : CustomerShoppingException - It is raised when Furniturename not present
	 * 
	 * @throws CustomerShoppingException
	 **/
	@Override
	public Furniture getFurnitureByName(String furnitureName) throws CustomerShoppingException {

		Optional<Furniture> resultUser = Optional.ofNullable(furnitureRepo.findbyName(furnitureName));
		if (resultUser == null) {
			throw new CustomerShoppingException("No furniture found");
		}

		else {
			logger.info("Fetching Furnitures inprogress...");
			Furniture result = furnitureRepo.findbyName(furnitureName);
			if (resultUser.isPresent()) {
				logger.info("Furniture details: " + result);
				return result;
			} else {
				throw new CustomerShoppingException("Furniture not Present");
			}
		}

	}

	
	/**
	 * Description :To add Cart to the database 
	 * Input Params :Cart object to be added to the database 
	 * Return Value :Cart object 
	 * Exception : CustomerShoppingException - It is raised Cart Furniture already exist
	 * 
	 * throws CustomerShoppingException
	 **/
	
	@Override
	public Cart addtoCart(Cart furniture) throws CustomerShoppingException {

		if ((furniture.getCartId()!= 0)) {

			logger.info("Fetching Cart inprogress...");
			Cart updateUser = cartRepo.save(furniture);
			logger.info("Cart details: " + updateUser);
			return updateUser;

		} else {
			throw new CustomerShoppingException("Furniture not added to cart");

		}
	}

	
	/**
	 * Description :To add FurnitureOrder to the database 
	 * Input Params :FurnitureORder object to be added to the database 
	 * Return Value :Furniture order object 
	 * Exception : CustomerShoppingException - It is raised when FurnitureOrder already exist
	 * 
	 * throws CustomerShoppingException
	 **/
	@Override
	public Order placeOrder(Order order) throws CustomerShoppingException {
		if ((order.getOrderId()!=null)) {

			logger.info("Fetching Order inprogress...");
			Order placeOrder = orderRepo.save(order);
			logger.info("Order details: " + placeOrder);
			return placeOrder;

		} else {
			throw new CustomerShoppingException("Order cannot be placed");

		}
	}
}
