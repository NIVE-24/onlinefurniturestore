package com.onlinefurniturestore.OnlineFurnitureStore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.controller.ReportController;

@SpringBootTest
public class ReportControllerTest {
	
	@Autowired
	private ReportController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
