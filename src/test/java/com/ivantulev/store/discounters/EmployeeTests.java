package com.ivantulev.store.discounters;

import static org.junit.Assert.assertEquals;

import com.ivantulev.store.dto.Account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeTests {

	@Test
	public void testGetDiscount() {
        Employee employee = new Employee();
        int price = 110;
        String itemType = "Car";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        employee.build(account, itemType, price);
        assertEquals((Double)77.0, (Double)employee.getDiscount());
    }

    @Test
    public void testWithoutDiscount() {
        Employee employee = new Employee();
        int price = 110;
        String itemType = "Grocery";
        Account account = new Account();
        account.setPeriod(String.valueOf(3));
        employee.build(account, itemType, price);
        assertEquals((Double)110.0, (Double)employee.getDiscount());
    }
}