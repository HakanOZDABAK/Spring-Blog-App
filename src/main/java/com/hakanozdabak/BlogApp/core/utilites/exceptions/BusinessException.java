package com.hakanozdabak.BlogApp.core.utilites.exceptions;

public class BusinessException extends  RuntimeException{
    public BusinessException(String message){
        super(message);
    }
}
