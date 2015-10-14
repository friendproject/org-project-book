package com.test.velocity.core;

/**
 * Created by Ankur on 11-10-2015.
 */
public enum Exceptions {

    USER_NOT_VALIDATED("Unable to find User"),
    UNABLE_TO_GET_MONGO_CONNECTION("Unable to connect with Mongo");

    private String exception;

    private Exceptions(String exception) {

        this.exception = exception;
    }


    public static String getException(Exceptions exceptions){
        return (exceptions.exception);
    }
}
