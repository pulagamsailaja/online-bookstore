package com.bookstore.OnlineBookStore.designpatterns.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public String pay(float amount) {
        return "Paid ₹" + amount + " via PayPal.";
    }
}
