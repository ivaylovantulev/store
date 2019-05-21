package com.ivantulev.store.responsers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponserTests {

	@Autowired
	Responser responser;

	@Test
	public void getAmountTest() {
		// Responser responser = new Responser();
		responser.build("1", "Car", 100);
		assertTrue(responser instanceof Responser);
		assertTrue("70.0".equals(responser.getAmmount()));
	}

}