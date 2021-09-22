package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Bill;
import com.entity.Card;
import com.service.PaymentService;

/**
 * Author: NIVEDHA M 
 * Date:17-09-2021 
 * Description:This is Payment Controller Layer
 **/


@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value ="/bills", method = RequestMethod.GET)
	public ResponseEntity<Bill> getBillById(@RequestParam long billNo) {
		return new ResponseEntity<>(paymentService.getBillById(billNo),HttpStatus.OK);
	}
	
	@RequestMapping(value ="/paybycash", method = RequestMethod.PUT)
	public ResponseEntity<String> payByCash(@RequestParam double amount) throws Exception {
		double change = paymentService.payByCash(amount);
		if(change == 0) {
			return new ResponseEntity<>("Your transaction is completed.. ",HttpStatus.OK);
		} else if(change < 0) {
			return new ResponseEntity<>("Please take the change: "+change,HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Your Due amount is: "+change,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value ="/paybycard", method = RequestMethod.POST)
	public ResponseEntity<String> payByCard(@RequestBody Card card) throws Exception {
		Card result = paymentService.payByCard(card);
		return new ResponseEntity<>("Transaction is completed for the card: "+result.getCardNum(), HttpStatus.OK);
	}

}
