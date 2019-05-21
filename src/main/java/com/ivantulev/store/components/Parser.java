/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.components;

import com.ivantulev.store.dto.Account;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/**
 * Simple JSON file parser
 */
@Component
public class Parser {
    
    /**
     * Class field
     */
    protected JSONParser parser;

    /**
     * Class Constructor
     */
    Parser() {
        this.parser = new JSONParser();
    }

    /**
     * Get Account Method
     * 
     * @param Id  the key for getting the corresponding account
     * @return account
     */
    public Account getAccount(String Id) {
        try (FileReader reader = new FileReader("/home/ivantulev/dev/store/src/main/java/com/ivantulev/store/resources/accounts.json"))
        {
            JSONObject obj = (JSONObject)this.parser.parse(reader);
            JSONObject jsonAccount = (JSONObject)obj.get(Id);
            
            /**
             * Create and build new Account object, reading from file
             */
            Account account = new Account();
            account.setUsername((String)jsonAccount.get("username"));
            account.setPassword((String)jsonAccount.get("password"));
            account.setType((String)jsonAccount.get("type"));
            account.setPeriod((String)jsonAccount.get("period"));
            
            return account;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
    
            return null;

        } catch (IOException e) {
            e.printStackTrace();
    
            return null;
    
        } catch (ParseException e) {
            e.printStackTrace();
    
            return null;
        }
    }
}