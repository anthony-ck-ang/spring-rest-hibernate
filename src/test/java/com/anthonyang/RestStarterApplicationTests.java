package com.anthonyang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.anthonyang.RestErrorHandlingApplication;

import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestErrorHandlingApplication.class)
@WebAppConfiguration
public class RestStarterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
