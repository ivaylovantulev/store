/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.service;

import com.ivantulev.store.domain.Account;
import com.ivantulev.store.components.discounters.User;
import com.ivantulev.store.repository.Parser;
import com.ivantulev.store.components.Factory;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Class Responser
 * 
 * It is mapped to particular REST Endpoint and generate
 * the POST Response
 */
@Scope("prototype")
@Component
public class Responser {

    /**
     * Factory Field
     */
    @Autowired
    Factory factory;

    /**
     * Parser Field - Simple json file parser, used for getting the Account according to requested User ID 
     */
    @Autowired
    Parser parser;

    /**
     * Class Fields
     */
    String itemType;
    int price;
    Account account;

    /**
     * Build method
     * 
     * It is a builder pattern - dependencies are outside of the constructor
     * prevents circular dependency
     *
     * @param userId  gived from the rest requiest (simulating security token)
     * @param itemType  given from the rest request, this is the type of the requested Item 
     * @param price  given from the rest request, the price of the requested Item
     * @param account  according to the given user ID, the responser read the stored Accounts.
     * 
     * For simulation of Account Srore here a json file is used. 
     */
    public void build(String userId, String itemType, int price) {
        this.itemType = itemType;
        this.price = price;
        this.account = parser.getAccount(userId);
    }

    /**
     * Get Response method - generate the response
     * @return string
     */
    public String getResponse() {

        /**
         * Usint the Factory pattern for create an object according to account type
         * 
         * The user object is a Discounter which calculate the discount
         */
        Optional<User> user = factory.getUser(this.account.getType());
        
        if (user.isPresent()) {
            /**
             * Build the user discounter
             */
            user.get().build(this.account, this.itemType, this.price);

            /**
             * Get the user discounted price
             */
            return String.valueOf(user.get().getDiscount());
        }

        return "";
    }

}