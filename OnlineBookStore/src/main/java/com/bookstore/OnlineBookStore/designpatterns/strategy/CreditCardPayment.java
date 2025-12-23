package com.bookstore.OnlineBookStore.designpatterns.strategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public String pay(float amount) {
        return "Paid ₹" + amount + " via Credit Card.";
    }
}
