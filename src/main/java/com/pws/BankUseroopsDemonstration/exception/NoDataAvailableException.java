package com.pws.BankUseroopsDemonstration.exception;

public class NoDataAvailableException extends RuntimeException{

    String message = "No data found in the data base";

    public NoDataAvailableException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
