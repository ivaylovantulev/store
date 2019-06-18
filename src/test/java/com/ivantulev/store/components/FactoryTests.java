package com.ivantulev.store.components;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import com.ivantulev.store.components.discounters.Employee;
import com.ivantulev.store.components.discounters.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FactoryTests {

	@Test
	public void testFactory() {
		Factory factory = new Factory();
		Optional<User> user = factory.getUser("Employee");
		Optional<User> user2 = factory.getUser("Goal");

		assertTrue(user.get() instanceof Employee);
		assertFalse(user2.isPresent());
	}

}