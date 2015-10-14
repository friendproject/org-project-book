package com.test.velocity.exceptions;

/**
 * Created by Ankur on 11-10-2015.
 */
public class UserValidationException extends RuntimeException{

    public UserValidationException(){
        super();
    }

    public UserValidationException(String exception) {
        super(exception);
    }
}
