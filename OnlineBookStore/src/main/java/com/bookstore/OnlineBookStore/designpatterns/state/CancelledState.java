package com.bookstore.OnlineBookStore.designpatterns.state;

public class CancelledState implements OrderState {
    @Override
    public String updateStatus() {
        return "Order has been cancelled.";
    }
}
