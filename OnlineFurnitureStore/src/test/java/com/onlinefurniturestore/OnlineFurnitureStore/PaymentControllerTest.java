package com.onlinefurniturestore.OnlineFurnitureStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controller.PaymentController;

@SpringBootTest
public class PaymentControllerTest {
	@Autowired
	private PaymentController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
