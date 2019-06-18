package com.ivantulev.store.components.discounters;

import static org.junit.Assert.assertEquals;

import com.ivantulev.store.domain.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {

	@Test
	public void testGetDiscount() {
        Customer customer = new Customer();
        int price = 110;
        String itemType = "Car";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        customer.build(account, itemType, price);
        assertEquals((Double)104.5, (Double)customer.getDiscount());
        account.setPeriod(String.valueOf(1));
        assertEquals((Double)105.0, (Double)customer.getDiscount());
    }

    @Test
    public void testWithoutDiscount() {
        Customer customer = new Customer();
        int price = 110;
        String itemType = "Grocery";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        customer.build(account, itemType, price);
        assertEquals((Double)110.0, (Double)customer.getDiscount());
    }
}