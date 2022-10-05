package com.example.SpringBootRestApp.exeptions;

public class ShopNotFoundException extends Exception {
    public ShopNotFoundException(String message) {
        super(message);
    }
}
