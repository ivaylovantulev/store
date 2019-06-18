/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.components.discounters;

import org.springframework.stereotype.Component;

/**
 * Class Employee concrete discounter
 */
@Component
public class Employee extends User {

    /**
     * Get Discount Method
     * 
     * Claculating the price
     * 
     * @return Double
     */
    public Double getDiscount() {

        /**
         * Some Item types has no discount
         */
        if (this.applyDiscount()) {
            return this.price - (this.price * 30 * 0.01);
        }
    
        return Double.valueOf(this.price);
    }
}