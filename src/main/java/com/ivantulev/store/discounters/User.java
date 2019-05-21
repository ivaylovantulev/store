/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.discounters;

import com.ivantulev.store.dto.Account;

import org.springframework.stereotype.Component;

/**
 * Class User Discounter
 * 
 * An Abstract class  Price calculator
 */
@Component
public abstract class User {

    /**
     * Class Fields
     */
    protected Account account;
    protected String itemType;
    protected int price;

    /**
     * Abstract get Discount method  implemented by the childs
     * 
     * @return Double
     */
    public abstract Double getDiscount();

    /**
     * Build method
     * 
     * It is a builder pattern - dependencies are outside of the constructor
     * prevents circular dependency
     *
     * @param account  differen calculation according to the type of the account
     * @param itemType  needs for apply discount condition - some item type has no discount 
     * @param price  The price of the requested Item
     */
    public void build(Account account, String itemType, int price) {
        this.account = account;
        this.itemType = itemType;
        this.price = price;
    }

    /**
     * Apply Discount Method
     * 
     * Some Item types has no discount
     *
     * @return boolean
     */
    protected Boolean applyDiscount() {
        if ("Grocery".equals(this.itemType)) {
            return false;
        }
        return true;
    }
}