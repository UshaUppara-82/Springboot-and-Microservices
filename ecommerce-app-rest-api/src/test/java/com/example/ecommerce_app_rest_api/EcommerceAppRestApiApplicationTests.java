package com.example.ecommerce_app_rest_api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceAppRestApiApplicationTests {

	@Test
	void contextLoads() {
		//Compare the actual value with expected value
		int a = 1 + 1; //replace with this method call
		assertEquals(a, 2);
	}

}
