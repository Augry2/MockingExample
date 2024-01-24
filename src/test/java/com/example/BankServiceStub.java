package com.example;

public class BankServiceStub implements BankService {
    @Override
    public void pay(String id, double amount) {
        System.out.println("payment successful to user with id: " + id);
    }
}
