package com.bookstore.OnlineBookStore.designpatterns.state;

public class DeliveredOrderState implements OrderState {
    @Override
    public String updateStatus() {
        return "Order has been delivered. Thank you for shopping!";
    }
}
