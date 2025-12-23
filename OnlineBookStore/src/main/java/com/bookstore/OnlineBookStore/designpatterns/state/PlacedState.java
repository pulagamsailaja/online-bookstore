package com.bookstore.OnlineBookStore.designpatterns.state;

public class PlacedState implements OrderState {
    @Override
    public String updateStatus() {
        return "🟢 Order has been placed successfully!";
    }
}
