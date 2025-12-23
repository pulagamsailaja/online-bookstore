package com.bookstore.OnlineBookStore.designpatterns.strategy;

public class CashOnDeliveryPayment implements PaymentStrategy {

    @Override
    public String pay(float amount) {
        return "Cash on Delivery - Pay " + amount + " at the time of delivery";
    }
}
