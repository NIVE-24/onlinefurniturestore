package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Order;
import com.service.ReportService;

/**
 * Author: NIVEDHA M 
 * Date:18-09-2021 
 * Description:This is Report Controller Layer
 **/


@RestController
@RequestMapping("/report")
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping(value = "/bills", method = RequestMethod.GET)
	public ResponseEntity<List<Bill>> getBills(){
		return new ResponseEntity<>(reportService.getAllBills(),HttpStatus.OK);
	}
	
	@RequestMapping(value ="/customers", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers(){
		return new ResponseEntity<>(reportService.getAllCustomers(),HttpStatus.OK);
	}
	
	@RequestMapping(value ="/carts", method = RequestMethod.GET)
	public ResponseEntity<List<Cart>> getAllCarts(){
		return new ResponseEntity<>(reportService.getAllCarts(),HttpStatus.OK);
	}
	
	@RequestMapping(value ="/orders", method = RequestMethod.GET)
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<>(reportService.getAllOrders(),HttpStatus.OK);
	}
	
}
