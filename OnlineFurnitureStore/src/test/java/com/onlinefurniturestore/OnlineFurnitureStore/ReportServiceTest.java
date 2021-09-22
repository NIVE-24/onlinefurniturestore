package com.onlinefurniturestore.OnlineFurnitureStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.junit.Before;

import com.entity.Bill;
import com.entity.Cart;
import com.entity.Customer;
import com.entity.Order;
import com.serviceimpl.ReportServiceImpl;

@SpringBootTest(classes = { OnlineFurnitureStoreApplication.class })
public class ReportServiceTest extends AbstractTest{
	
	@MockBean
	ReportServiceImpl reportService;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		prepareMockData();
	}
	
	
	List<Bill> bills = new ArrayList<Bill>();
	List<Customer> customers = new ArrayList<Customer>();
	List<Cart> carts = new ArrayList<Cart>();
	List<Order> orders = new ArrayList<Order>();
	
	void prepareMockData(){
		bills.addAll(Arrays.asList(new Bill(),new Bill(),new Bill()));
		customers.addAll(Arrays.asList(new Customer(),new Customer(),new Customer()));
		carts.addAll(Arrays.asList(new Cart(),new Cart(),new Cart()));
		orders.addAll(Arrays.asList(new Order(),new Order(),new Order()));
	}
	
	
	@Test
	void getAllBillsTest() {
		when(reportService.getAllBills()).thenReturn(bills);
		List<Bill> testBills = reportService.getAllBills();
		assertEquals(bills, testBills);
		verify(reportService,atLeastOnce()).getAllBills();
	}
	
	@Test
	void getAllCustomersTest() {
		when(reportService.getAllCustomers()).thenReturn(customers);
		List<Customer> testCustomer = reportService.getAllCustomers();
		assertEquals(customers, testCustomer);
		verify(reportService, atLeastOnce()).getAllCustomers();
	}
	
	@Test
	void getAllCartsTest() {
		when(reportService.getAllCarts()).thenReturn(carts);
		List<Cart> testCarts = reportService.getAllCarts();
		assertEquals(carts, testCarts);
		verify(reportService, atLeastOnce()).getAllCarts();
	}
	
	@Test
	void getAllOrders() {
		when(reportService.getAllOrders()).thenReturn(orders);
		List<Order> testOrders= reportService.getAllOrders();
		assertEquals(orders, testOrders);
		verify(reportService, atLeastOnce()).getAllOrders();
	}

}
