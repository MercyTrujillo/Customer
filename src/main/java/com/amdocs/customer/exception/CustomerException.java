package com.amdocs.customer.exception;

public class CustomerException extends RuntimeException {

    private String message;

    public CustomerException(String message){
        // Mercy will check what is the use for super
        // super(message);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
