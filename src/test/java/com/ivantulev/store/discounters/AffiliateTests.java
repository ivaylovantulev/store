package com.ivantulev.store.discounters;

import static org.junit.Assert.assertEquals;

import com.ivantulev.store.dto.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AffiliateTests {

	@Test
	public void testGetDiscount() {
        Affiliate affiliate = new Affiliate();
        int price = 110;
        String itemType = "Car";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        affiliate.build(account, itemType, price);
        assertEquals((Double)99.0, (Double)affiliate.getDiscount());
    }

    @Test
    public void testWithoutDiscount() {
        Affiliate affiliate = new Affiliate();
        int price = 110;
        String itemType = "Grocery";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        affiliate.build(account, itemType, price);
        assertEquals((Double)110.0, (Double)affiliate.getDiscount());
    }
}