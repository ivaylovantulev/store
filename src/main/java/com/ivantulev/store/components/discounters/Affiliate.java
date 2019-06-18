/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.components.discounters;

import org.springframework.stereotype.Component;

/**
 * Class Affiliate concrete discounter
 */
@Component
public class Affiliate extends User {

    /**
     * Get Discount Method
     * 
     * Claculating the price
     * 
     * @return Double
     */
    @Override
    public Double getDiscount() {

        /**
         * Some Item types has no discount
         */
        if (this.applyDiscount()) {
            return this.price - (this.price * 10 * 0.01);
        }

        return Double.valueOf(this.price);
    }
}