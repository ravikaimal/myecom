package com.rkkaimal.myecom.exceptions;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(Long id){
        super(String.format("Product with id [%id] Not Found",id));
    }
}
