package com.service;

import com.entity.Bill;
import com.entity.Card;

public interface PaymentService {
	Bill getBillById(long billNo);
	double payByCash(double amount) throws Exception;
	Card payByCard(Card card) throws Exception;

}
