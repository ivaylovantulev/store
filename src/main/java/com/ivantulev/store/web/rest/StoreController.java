/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.web.rest;

import com.ivantulev.store.service.Responser;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * REST API Controller Class 
 */
@RestController
public class StoreController {

    /**
     * Responser field 
     */
    @Autowired
    Responser responser;

    /**
     * Discount method mapped to '/discount' Endpoint
     * 
     * @param body represents the body of the POST request  
     */
    @PostMapping("/discount")
    @ResponseBody 
    ResponseEntity<String> discount(@RequestBody Body body) {

        /**
         * Builder pattern - prevents from circular dependencies
         */
       responser.build(body.getUserId(), body.getItemType(), body.getPrice());

        if ("".equals(responser.getResponse())) {
            return ResponseEntity.badRequest().body("POST Body: userId, itemType, price");
        }

        return ResponseEntity.ok().body(" Your price: " + responser.getResponse());
    }

}
