package com.emilrosenius.application.exceptions;

public class NegativeTaxAmountException extends Exception {

    public NegativeTaxAmountException(String s) {
        super(s);
    }

}
