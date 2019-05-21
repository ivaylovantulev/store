package com.ivantulev.store.components;

import static org.junit.Assert.assertEquals;

import com.ivantulev.store.dto.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParserTests {

	@Test
	public void testParser() {
        Parser parser = new Parser();
        Account a = parser.getAccount("1");
        assertEquals("Employee", a.getType());
        assertEquals("Ivaylo", a.getUsername());
        assertEquals("pass1", a.getPassword());
        assertEquals("N/A", a.getPeriod());
    }

}