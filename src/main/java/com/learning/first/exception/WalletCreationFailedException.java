package com.learning.first.exception;

public class WalletCreationFailedException extends RuntimeException{

    public WalletCreationFailedException(String Message)
    {
        super(Message);
    }
}
