package com.bookstore.OnlineBookStore.designpatterns.state;

public class ShippedOrderState implements OrderState {
    @Override
    public String updateStatus() {
        return "Order has been shipped to your address.";
    }
}
