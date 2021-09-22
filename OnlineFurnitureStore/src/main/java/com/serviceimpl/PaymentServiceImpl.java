package com.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entity.Bill;
import com.entity.Card;
import com.entity.Customer;
import com.entity.Order;
import com.exception.OnlineStoreException;
import com.repository.BillRepository;
import com.repository.CustomerRepository;
import com.repository.OrderRepository;
import com.service.PaymentService;

@Component
public class PaymentServiceImpl implements PaymentService {

	Logger logger = Logger.getLogger(PaymentServiceImpl.class);

	@Autowired
	BillRepository billRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderRepository orderRepository;

	@Override
	public Bill getBillById(long billNo) {
		return billRepository.findById(billNo);
	}

	@Override
	public double payByCash(double amount) throws Exception {
		// get username from session
		// user object must contain email, username from session
		String username = "nivedha";
		String email = "nivedha@gmail.com";
		Customer customer = customerRepository.findByEmail(email);
		Bill bill = billRepository.findByCustomer(username);
		double change = bill.getAmount() - amount;
		try {
			if (change == 0 || change < 0) {
				Order order = new Order(UUID.randomUUID().toString(), new Date(), bill.getFurniture(), customer,
						bill.getQuanity(), bill.getPrice(), bill.getAmount(), "paid");
				orderRepository.save(order);
			} else {
				throw new Exception("You need to pay: " + bill.getAmount());
			}
		} catch (Exception e) {
			logger.info("Invalid amount, Required: " + bill.getAmount() + " but Recieved: " + amount);
			throw e;
		}
		return change;
	}

	@Override
	public Card payByCard(Card card) throws Exception {
		// get username & email from session
		String username = "nivedha";
		String email = "nivedha@gmail.com";
		Customer customer = customerRepository.findByEmail(email);
		Bill bill = billRepository.findByCustomer(username);
		if (isCardValid(card)) {
			Order order = new Order(UUID.randomUUID().toString(), new Date(), bill.getFurniture(), customer,
					bill.getQuanity(), bill.getPrice(), bill.getAmount(), "paid");
			orderRepository.save(order);
		}
		card.setCardNum("XXXXXX"+card.getCardNum().substring(card.getCardNum().length()-3));
		return card;
	}

	private boolean isCardValid(Card card) throws Exception {
		if(StringUtils.isNotEmpty(card.getCardNum()) && StringUtils.isNotEmpty(card.getCvv())) {
			if (card.getCvv().length() != 3) {
				throw new OnlineStoreException("Invalid CVV");
			}
			if (card.getCardNum().length() != 9) {
				throw new OnlineStoreException("Invalid card number");
			}
			if (null == card.getExpiryDate()) {
				throw new OnlineStoreException("Card expirty date is invalid. Cause: ExpiryDate object is null");
			} else {
				if(StringUtils.isNotEmpty(card.getExpiryDate().getYear()) && StringUtils.isNotEmpty(card.getExpiryDate().getMonth())) {
					if(Integer.parseInt(card.getExpiryDate().getYear()) < Calendar.YEAR) {
						throw new OnlineStoreException("Card expirty date is invalid. Cause: Expiry year is invalid");
					}
					if(Integer.parseInt(card.getExpiryDate().getMonth())> 12 || Integer.parseInt(card.getExpiryDate().getMonth()) < 0) {
						throw new OnlineStoreException("Card expirty date is invalid. Cause: Expiry month is invalid");
					}
				}
			}
			return true;
		} else {
			return false;
		}
		
	}
}
