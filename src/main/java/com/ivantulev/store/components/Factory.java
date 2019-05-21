/**
 * JAVA Based Store REST API
 * @author Ivaylo Vantulev ivaylo.vantulev@primeholding.com
 */

package com.ivantulev.store.components;

import com.ivantulev.store.discounters.User;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import org.springframework.stereotype.Component;

/**
 * Class Factory
 * 
 * A factory pattern using Class Reflection
 * Create an object by passed string
 */
@Component
public class Factory {

    /**
     * Get User Method
     * 
     * @param userName
     * @return user
     */
    public Optional<User> getUser(String userName) {

        try {

            /**
             * Using Class Reflection
             */
            Class<?> user = Class.forName("com.ivantulev.store.discounters." + userName);
            User object;
            object = (User)user.getConstructor().newInstance();

            return Optional.of(object);

        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();

            return Optional.empty();
        }
     }
}