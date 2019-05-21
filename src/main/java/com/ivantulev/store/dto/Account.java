/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.dto;

/**
 * Class Account DTO
 */
public class Account {
    
    /**
     * Class Fields
     */
    private String username;
    private String password;
    private String type;
    private String period;
    
    /**
     * Getters and Setters
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getType() {
        return this.type;
    }

    public String getPeriod() {
        return this.period;
    }
}