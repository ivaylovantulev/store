/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.components.discounters;

/**
 * Class Customer concrete discounter
 */
public class Customer extends User {

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

            /**
             * Different discount for according to period of customer activity
             */
            if (Integer.parseInt(this.account.getPeriod()) > 2) {
                return this.price - (this.price * 5 * 0.01);
            } else {
                return (double) (this.price - (Math.round(price / 100)) * 5);
            }
        }

        return Double.valueOf(this.price);
    }
}