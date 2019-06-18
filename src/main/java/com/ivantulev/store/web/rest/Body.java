/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.web.rest;

import org.springframework.stereotype.Component;

/**
 * Class Body
 * 
 * DTO with post request Body fields
 */
@Component
public class Body {

    /**
     * Class Fields
     */
    private String userId;
    private String itemType;
    private int price;

    /**
     * Getters and Setters
     */
    public void setItemType(String type) {
        this.itemType = type;
    }
    public void setUserId(String type) {
        this.userId = type;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public String getItemType() {
        return this.itemType;
    }
    public String getUserId() {
        return this.userId;
    }
    public int getPrice() {
        return this.price;
    }

}