package com.bookstore.OnlineBookStore.designpatterns.strategy;

public class PaymentContext {

    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public String executePayment(float amount) {
        return strategy.pay(amount);
    }
}
