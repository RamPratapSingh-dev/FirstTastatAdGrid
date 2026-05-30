package com.learning.first.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;


public class InvalidAuthenticationToken extends RuntimeException {
   public InvalidAuthenticationToken(String message)
    {
        super(message);
    }
}
